package stacks.queues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RainWaterTrapped {

    public int trap(final List<Integer> nums) {
        List<Integer> right = new ArrayList<>();
        List<Integer> left = new ArrayList<>();
        int max = 0;
        for (int num : nums) {
            left.add(max);
            max = Math.max(max, num);
        }
        max = 0;
        for (int i = nums.size() - 1; i >= 0; i--) {
            right.add(max);
            max = Math.max(max, nums.get(i));
        }
        Collections.reverse(right);
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            int l = left.get(i);
            int r = right.get(i);
            if (l > nums.get(i) && r > nums.get(i)) {
                ans += Math.min(l - nums.get(i), r - nums.get(i));
            }
        }
        return ans;
    }
}
