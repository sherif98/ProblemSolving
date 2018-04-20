package binary.search;

import java.util.List;
import java.util.function.BiFunction;

public class CountElementOccurence {

    public int findCount(final List<Integer> nums, int target) {
        int firstIdx = binarySearch(nums, target,
                (lo, mid) -> lo,
                (hi, mid) -> mid,
                (lo, hi) -> lo + (hi - lo) / 2);

        if (nums.get(firstIdx) != target) {
            return 0;
        }

        int lastIdx = binarySearch(nums, target,
                (lo, mid) -> mid,
                (hi, mid) -> hi,
                (lo, hi) -> lo + (hi - lo + 1) / 2);

        return lastIdx - firstIdx + 1;

    }

    private int binarySearch(List<Integer> nums, int target,
                             BiFunction<Integer, Integer, Integer> updateLo,
                             BiFunction<Integer, Integer, Integer> updateHi,
                             BiFunction<Integer, Integer, Integer> updateMid) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            int mid = updateMid.apply(lo, hi);
            if (nums.get(mid) == target) {
                lo = updateLo.apply(lo, mid);
                hi = updateHi.apply(hi, mid);
            } else if (nums.get(mid) < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }
}
