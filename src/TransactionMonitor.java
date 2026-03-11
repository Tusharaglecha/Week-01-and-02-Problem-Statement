import java.util.*;

public class TransactionMonitor {
    public void findTwoSum(int[] amounts, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < amounts.length; i++) {
            int complement = target - amounts[i];
            if (map.containsKey(complement)) {
                System.out.println("Pair found: " + complement + " and " + amounts[i]);
            }
            map.put(amounts[i], i);
        }
    }
}

