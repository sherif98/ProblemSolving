package binary.search;

import java.util.List;

public class RotatedSortedArraySearch {

    public int search(final List<Integer> nums, int target) {
        int pivot = findPivot(nums);
        if (pivot == -1) {
            return binarySearch(nums, target, 0, nums.size() - 1);
        }
        if (nums.get(pivot) == target) {
            return pivot;
        }
        int lower = binarySearch(nums, target, 0, pivot - 1);
        if (lower != -1) {
            return lower;
        }
        return binarySearch(nums, target, pivot + 1, nums.size() - 1);
    }

    private int findPivot(List<Integer> nums) {
        int lo = 0;
        int hi = nums.size() - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums.get(mid) > nums.get(hi)) {
                lo = mid + 1;
            } else if (nums.get(mid) < nums.get(lo)) {
                hi = mid - 1;
            } else {
                int x = nums.get(lo);
                if (lo > 0 && x < nums.get(lo - 1)) {
                    return lo;
                }
                int y = nums.get(hi);
                if (hi < nums.size() - 1 && y > nums.get(hi + 1)) {
                    return hi;
                }
                return -1;
            }
        }
        return -1;
    }

    private int binarySearch(List<Integer> nums, int target, int start, int end) {
        int lo = start;
        int hi = end;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums.get(mid) == target) {
                return mid;
            } else if (nums.get(mid) > target) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }
}
