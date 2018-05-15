package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class FirstMissingInteger {


    public int firstMissingPositive(ArrayList<Integer> nums) {
        int shift = moveNegatives(nums);
        if (shift == nums.size()) {
            return 1;
        }
        for (int i = shift; i < nums.size(); i++) {
            int n = Math.abs(nums.get(i));
            if (n - 1 + shift < nums.size() && nums.get(n - 1 + shift) > 0) {
                nums.set(shift + n - 1, -1 * nums.get(n - 1 + shift));
            }
        }
        for (int i = shift; i < nums.size(); i++) {
            if (nums.get(i) > 0) {
                return i - shift + 1;
            }
        }
        return nums.size() - shift + 1;
    }

    private int moveNegatives(ArrayList<Integer> nums) {
        int shift = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) <= 0) {
                Collections.swap(nums, i, shift++);
            }
        }
        return shift;
    }
}
