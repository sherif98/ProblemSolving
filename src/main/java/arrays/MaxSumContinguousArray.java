package arrays;

import java.util.List;

public class MaxSumContinguousArray {

    public int maxSubArray(final List<Integer> nums) {
        if (nums.isEmpty()) {
            return 0;
        }
        int min = Integer.MIN_VALUE;
        boolean allNeg = true;
        for (int n : nums) {
            if (n > 0) {
                allNeg = false;
                break;
            }
            min = Math.max(min, n);
        }
        if (allNeg) {
            return min;
        }
        int maxEndingHere = 0;
        int maxSoFar = 0;
        for (int i = 1; i < nums.size(); i++) {
            int n = nums.get(i);
            maxEndingHere += n;
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }
}
