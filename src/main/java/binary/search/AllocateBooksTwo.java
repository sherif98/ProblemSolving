package binary.search;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooksTwo {

    public static void main(String[] args) {
        AllocateBooksTwo allocateBooks = new AllocateBooksTwo();
        int books = allocateBooks.books
                (new ArrayList<>(Arrays.asList(3, 32, 32, 41, 54, 77, 17)), 4);
        System.out.println(books);
    }

    public int books(ArrayList<Integer> nums, int m) {

        if (m == 0 || nums.size() < m) {
            return -1;
        }
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int ret = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canCalculate(nums, mid, m)) {
                ret = Math.min(ret, mid);
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ret;
    }

    private boolean canCalculate(ArrayList<Integer> nums, int maxPages, int m) {
        int cnt = 1;
        int sum = 0;
        for (int n : nums) {
            if (n > maxPages) {
                return false;
            }
            if (sum + n > maxPages) {
                sum = n;
                cnt++;
            } else {
                sum += n;
            }
        }
        return cnt <= m;
    }

}
