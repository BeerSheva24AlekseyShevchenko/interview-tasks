package telran.interview;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

public class ConnectionPoolTest {

    @Test
    void addConnectionTest() {
        ConnectionPool pool = new ConnectionPool(3);
        Connection connection = new Connection("1");
        pool.addConnection(connection);
        assertThrows(IllegalStateException.class, () -> pool.addConnection(connection));
    }

    @Test
    void getConnectionTest() {
        ConnectionPool pool = new ConnectionPool(3);
        Connection connection = new Connection("1");
        pool.addConnection(connection);
        assertEquals(connection, pool.getConnection("1"));
        assertThrows(NoSuchElementException.class, () -> pool.getConnection("2"));
    }

    @Test
    void overloadTest() {
        ConnectionPool pool = new ConnectionPool(2);
        Connection connection1 = new Connection("1");
        Connection connection2 = new Connection("2");
        Connection connection3 = new Connection("3");

        pool.addConnection(connection1);
        pool.addConnection(connection2);
        pool.addConnection(connection3);

        assertThrows(NoSuchElementException.class, () -> pool.getConnection("1"));
        assertEquals(connection2, pool.getConnection("2"));
        assertEquals(connection3, pool.getConnection("3"));
    }
}
