package telran.interview;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<DateRole> roles = new ArrayList<>();
        dates.forEach(i -> roles.add(getAvailableDateRole(rolesHistory, i)));

        return roles;
    }

    private static DateRole getAvailableDateRole(List<DateRole> rolesHistory, LocalDate date) {
        int begin = 0;
        int end = rolesHistory.size() - 1;
        String role = null;

        while (role == null && begin <= end) {
            int mid = (begin + end) / 2;
            DateRole midRole = rolesHistory.get(mid);
            int compare = date.compareTo(midRole.date());

            if (compare == 0) {
                role = midRole.role();
            } else if (compare < 0) {
                end = mid - 1;
            } else {
                begin = mid + 1;
            }
        }
        if (end >= 0) {
            role = rolesHistory.get(end).role();
        }

        return new DateRole(date, role);
    }

    public static boolean isAnagram(String word, String anagram) {        
        return !word.equals(anagram) && word.length() == anagram.length() && compareLetters(word, anagram);
    }

    private static boolean compareLetters(String str1, String str2) {
        HashMap<Character, Integer> wordMap = getWordLetters(str1);
        HashMap<Character, Integer> anagramMap = getWordLetters(str2);
        
        return wordMap.equals(anagramMap);
    }

    private static HashMap<Character, Integer> getWordLetters(String word) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            wordMap.merge(word.charAt(i), 1, Integer::sum);
        }
        return wordMap;
    } 
}