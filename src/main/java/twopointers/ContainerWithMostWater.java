package twopointers;

import java.util.*;

public class ContainerWithMostWater {

    public int maxArea(ArrayList<Integer> nums) {
        int lo = 0;
        int hi = nums.size() - 1;
        int ans = 0;
        while (lo < hi) {
            ans = Math.max(ans, Math.min(nums.get(lo), nums.get(hi)) * (hi - lo));
            if (nums.get(lo) < nums.get(hi)) {
                lo++;
            } else {
                hi--;
            }
        }
        return ans;
    }
}
