package telran.interview;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class AutoCompletion {
    TreeSet<String> words = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);

    public boolean addWord(String word) {
        return words.add(word);
    }

    public String[] getVariants(String prefix) {
        List<String> list = new ArrayList<>();
        Iterator<String> iterator = words.tailSet(prefix).iterator();
        String step = null;

        while (iterator.hasNext() && isStartsWith(step = iterator.next(), prefix)) {
            list.add(step);
        }

        return list.toArray(String[]::new);
    }

    private boolean isStartsWith(String str, String prefix) {
        return str.toLowerCase().startsWith(prefix.toLowerCase());
    }
}
