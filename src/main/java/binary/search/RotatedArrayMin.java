package binary.search;

import java.util.List;

public class RotatedArrayMin {


    public int findMin(final List<Integer> nums) {
        int pivot = findPivot(nums);
        if (pivot != -1) {
            return nums.get(pivot);
        }
        return -1;
    }

    private int findPivot(List<Integer> nums) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int midVal = nums.get(mid);
            if (midVal < nums.get(lo)) {
                hi = mid - 1;
            } else if (midVal > nums.get(hi)) {
                lo = mid + 1;
            } else {
                int x = nums.get(lo);
                if (lo > 0 && x < nums.get(lo - 1)) {
                    return lo;
                }
                int y = nums.get(hi);
                if (hi < nums.size() - 1 && y > nums.get(hi + 1)) {
                    return hi + 1;
                }
                return lo;
            }
        }
        return -1;
    }

}
