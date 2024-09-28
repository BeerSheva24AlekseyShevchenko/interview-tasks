package telran.interview;

import java.util.HashMap;
import java.util.Map;

public class InterviewTasks {
    /**
     * 
     * @param array
     * @param sum
     * @return true if a given array comprises of two number,
     *         summing of which gives the value equaled to a given "sum" value
     */
    static public boolean hasSumTwo(int[] array, int sum) {
        Map<Integer, Integer> map = new HashMap<>();

        int i = 0;
        boolean res = false;
        while (!res && i < array.length) {
            int pair = sum - array[i];
            
            if (map.containsKey(pair)) {
                res = true;
            }

            map.put(array[i], null);
            i++;
        }

        return res;
    }
}