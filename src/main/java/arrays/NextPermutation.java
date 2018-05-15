package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class NextPermutation {


    public void nextPermutation(ArrayList<Integer> nums) {
        int a = 0;
        int b = 0;
        for (int i = nums.size() - 2; i >= 0; i--) {
            int prev = nums.get(i + 1);
            if (nums.get(i) < prev) {
                a = i;
                break;
            }
        }
        for (int i = nums.size() - 1; i >= 0; i--) {
            int p = nums.get(a);
            if (nums.get(i) > p) {
                b = i;
                break;
            }
        }
        if (a == 0 && b == 0) {
            Collections.sort(nums);
            return;
        }
        Collections.swap(nums, a, b);
        reverse(nums, a + 1);
    }

    private void reverse(ArrayList<Integer> nums, int start) {
        int end = nums.size() - 1;
        while (start < end) {
            Collections.swap(nums, start++, end--);
        }
    }
}
