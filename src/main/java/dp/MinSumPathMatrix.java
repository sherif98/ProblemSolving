package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathMatrix {

    public int minPathSum(ArrayList<ArrayList<Integer>> A) {
        int[][] mem = new int[A.size()][A.get(0).size()];
        for (int[] a : mem) {
            Arrays.fill(a, -1);
        }
        return solve(0, 0, A.size(), A.get(0).size(), A, mem);
    }

    private int solve(int i, int j, int n, int m, ArrayList<ArrayList<Integer>> a,
                      int[][] mem) {
        if (i == n - 1 && j == m - 1) {
            return a.get(i).get(j);
        }
        if (i >= n || j >= m || i < 0 || j < 0) {
            return Integer.MAX_VALUE / 2;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int choice1 = a.get(i).get(j) + solve(i + 1, j, n, m, a, mem);
        int choice2 = a.get(i).get(j) + solve(i, j + 1, n, m, a, mem);
        return mem[i][j] = Math.min(choice1, choice2);
    }
}
