package dp;

import java.util.Arrays;

public class Stairs {

    public int climbStairs(int A) {
        int[] mem = new int[A];
        Arrays.fill(mem, -1);
        return solve(0, A, mem);
    }

    private int solve(int i, int n, int[] mem) {
        if (i == n) {
            return 1;
        }
        if (i > n) {
            return 0;
        }
        if (mem[i] != -1) {
            return mem[i];
        }
        return mem[i] = solve(i + 1, n, mem) + solve(i + 2, n, mem);
    }
}
