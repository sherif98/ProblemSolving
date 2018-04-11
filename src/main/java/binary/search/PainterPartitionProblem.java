package binary.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PainterPartitionProblem {

    public static void main(String[] args) {
        PainterPartitionProblem painterPartitionProblem = new PainterPartitionProblem();
        int paint = painterPartitionProblem.paint(1, 1000000, new ArrayList<>(Arrays.asList(1000000, 1000000)));
        System.out.println(paint);
    }


    public int paint(int k, int t, ArrayList<Integer> boards) {
        int lo = 0;
        int hi = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canCalculate(mid, boards, k)) {
                ans = Math.min(ans, mid) % 10000003;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return moduloMultiplication(ans, t, 10000003);
    }

    int moduloMultiplication(int a, int b, int mod) {
        int res = 0;
        a %= mod;
        while (b != 0) {
            if (b % 2 == 1) {
                res = (res + a) % mod;
            }
            a = (2 * a) % mod;
            b >>= 1;
        }

        return res;
    }

    private boolean canCalculate(int maxSize, ArrayList<Integer> boards, int k) {
        int cnt = 1;
        int sum = 0;
        for (int n : boards) {
            if (n > maxSize) {
                return false;
            }
            if (sum + n > maxSize) {
                sum = n;
                cnt++;
            } else {
                sum += n;
            }
        }
        return cnt <= k;
    }
}
