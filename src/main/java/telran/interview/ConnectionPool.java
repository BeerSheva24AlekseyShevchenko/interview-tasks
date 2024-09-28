package telran.interview;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class ConnectionPool {
    Map<String, Connection> pool;
    public ConnectionPool(int size) {
        initPool(size);
    }

    private void initPool(int size) {
        pool = new LinkedHashMap<>() {
            @Override
            protected boolean removeEldestEntry(java.util.Map.Entry<String, Connection> eldest) {
                return size() > size;
            }
        };
    }
           
    public void addConnection(Connection connection) {
        if (pool.containsKey(connection.connectionId())) {
            throw new IllegalStateException();
        }
        pool.put(connection.connectionId(), connection);
    }

    public Connection getConnection(String connectionId) {
        if (!pool.containsKey(connectionId)) {
            throw new NoSuchElementException();
        }
       
        return pool.get(connectionId);
    }
}