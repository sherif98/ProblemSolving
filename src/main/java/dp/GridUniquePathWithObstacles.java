package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class GridUniquePathWithObstacles {

    public int uniquePathsWithObstacles(ArrayList<ArrayList<Integer>> grid) {
        int n = grid.size() - 1;
        int m = grid.get(0).size() - 1;
        int[][] mem = new int[n + 1][m + 1];
        for (int[] a : mem) {
            Arrays.fill(a, -1);
        }
        return solve(grid, 0, 0, n, m, mem);
    }

    private int solve(ArrayList<ArrayList<Integer>> grid, int i, int j, int n, int m, int[][] mem) {
        if (i < 0 || j < 0 || i > n || j > m || grid.get(i).get(j) == 1) {
            return 0;
        }
        if (i == n && j == m) {
            return 1;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int ret = 0;
        ret += solve(grid, i + 1, j, n, m, mem);
        ret += solve(grid, i, j + 1, n, m, mem);
        return mem[i][j] = ret;
    }
}
