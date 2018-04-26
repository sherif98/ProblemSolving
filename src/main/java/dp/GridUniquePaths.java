package dp;

import java.util.Arrays;

public class GridUniquePaths {

    public int uniquePaths(int n, int m) {
        int[][] mem = new int[n][m];
        for (int[] a : mem) {
            Arrays.fill(a, -1);
        }
        return solve(0, 0, n, m, mem);
    }

    private int solve(int i, int j, int n, int m, int[][] mem) {
        if (i == n - 1 && j == m - 1) {
            return 1;
        }
        if (i < 0 || j < 0 || i >= n || j >= m) {
            return 0;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ret = 0;
        ret += solve(i, j + 1, n, m, mem);
        ret += solve(i + 1, j, n, m, mem);
        return mem[i][j] = ret;
    }
}
