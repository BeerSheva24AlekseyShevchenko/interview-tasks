package telran.interview;

import java.util.HashSet;
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
}