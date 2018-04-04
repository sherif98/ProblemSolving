package hashes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LargestContinuesZeroSum {

    public ArrayList<Integer> lszero(ArrayList<Integer> nums) {
        int start = -1;
        int end = -1;
        int length = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        map.put(0, -1);
        for (int i = 0; i < nums.size(); i++) {
            currentSum += nums.get(i);
            if (!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            } else {
                if (i + 1 - map.get(currentSum) > length) {
                    length = i + 1 - map.get(currentSum);
                    start = map.get(currentSum) + 1;
                    end = i + 1;
                }
            }
        }
        if (start == -1) {
            return new ArrayList<>();
        }
        return new ArrayList<>(nums.subList(start, end));
    }
}
