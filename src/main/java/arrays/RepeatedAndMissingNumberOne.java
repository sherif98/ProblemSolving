package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedAndMissingNumberOne {


    public ArrayList<Integer> repeatedNumber(final List<Integer> numbers) {
        List<Integer> nums = new ArrayList<>(numbers);
        int repeated = -1;
        for (int i = 0; i < nums.size(); i++) {
            int n = Math.abs(nums.get(i));
            int idx = n - 1;
            if (nums.get(idx) < 0) {
                repeated = n;
            } else {
                nums.set(idx, nums.get(idx) * -1);
            }
        }
        int missing = -1;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) > 0) {
                missing = i + 1;
            }
        }
        return new ArrayList<>(Arrays.asList(repeated, missing));
    }
}
