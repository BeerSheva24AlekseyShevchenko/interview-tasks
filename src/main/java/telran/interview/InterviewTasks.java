package telran.interview;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        Set<Integer> map = new HashSet<>();
        int i = 0;
        boolean res = false;
        while (!res && i < array.length) {
            if (map.contains(sum - array[i])) {
                res = true;
            }

            map.add(array[i]);
            i++;
        }

        return res;
    }

    static public int getMaxWithNegativePresentation(int[] array) {
        Set<Integer> tmp = new HashSet<>();
        int res = -1;

        for (int i = 0; i < array.length; i++) {
            if (tmp.contains(-array[i])) {
                res = Math.max(res, Math.abs(array[i]));
            }

            tmp.add(array[i]);
        }

        return res;
    }

    public static List<DateRole> assignRoleDates(List<DateRole> rolesHistory,
            List<LocalDate> dates) {
        TreeMap<LocalDate, String> history = new TreeMap<>();
        rolesHistory.forEach(i -> history.put(i.date(), i.role()));

        List<DateRole> roles = dates.stream().map(date -> {
            LocalDate floorKey = history.floorKey(date);
            String role = floorKey != null ? history.get(floorKey) : null;
            return new DateRole(date, role);
        }).toList();

        return roles;
    }

    public static boolean isAnagram(String word, String anagram) {        
        return !word.equals(anagram) && word.length() == anagram.length() && compareLetters(word, anagram);
    }

    private static boolean compareLetters(String str1, String str2) {
        HashMap<Character, Integer> wordMap = getWordLetters(str1);

        boolean res = true;
        int i = 0;
        while (res && i < str2.length()) {
            char letter = str2.charAt(i);
            int count = wordMap.getOrDefault(letter, 0);
            if (count == 0) res = false;
            wordMap.put(letter, count - 1);
            i++;
        }
        
        return res;
    }

    private static HashMap<Character, Integer> getWordLetters(String word) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            wordMap.merge(word.charAt(i), 1, Integer::sum);
        }
        return wordMap;
    } 
}