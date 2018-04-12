package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchForRange {


    public ArrayList<Integer> searchRange(final List<Integer> a, int b) {
        int start = searchForFirst(a, b);
        if (start < a.size() && a.get(start) == b) {
            int last = searchForLast(a, b);
            return new ArrayList<>(Arrays.asList(start, last));
        }
        return new ArrayList<>(Arrays.asList(-1, -1));
    }

    private int searchForFirst(List<Integer> nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums.get(mid) == target) {
                hi = mid;
            } else if (nums.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }

    private int searchForLast(List<Integer> nums, int target) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo < hi) {
            int mid = lo + (hi - lo + 1) / 2;
            if (nums.get(mid) == target) {
                lo = mid;
            } else if (nums.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
