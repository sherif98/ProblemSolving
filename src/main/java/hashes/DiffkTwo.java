package hashes;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DiffkTwo {

    public int diffPossible(final List<Integer> nums, int target) {
        Set<Integer> set = new HashSet<>(nums);
        if (target == 0) {
            return set.size() < nums.size() ? 1 : 0;
        }
        for (int n : nums) {
            if (set.contains(n - target)) {
                return 1;
            }
        }
        return 0;
    }
}
