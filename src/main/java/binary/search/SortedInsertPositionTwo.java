package binary.search;

import java.util.ArrayList;

public class SortedInsertPositionTwo {

    public int searchInsert(ArrayList<Integer> a, int b) {
        return binarySearch(a, b);
    }

    private int binarySearch(ArrayList<Integer> a, int target) {
        int lo = 0;
        int hi = a.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (a.get(mid) == target) {
                return mid;
            } else if (a.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return lo;
    }
}
