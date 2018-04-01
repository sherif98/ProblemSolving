package dp;

import java.util.ArrayList;
import java.util.Arrays;

public class MinSumPathTriangle {

    public int minimumTotal(ArrayList<ArrayList<Integer>> a) {
        int[][] mem = new int[a.size()][a.get(a.size() - 1).size()];
        for (int[] ar : mem) {
            Arrays.fill(ar, -1);
        }
        return solve(0, 0, a.size(), 1, a, mem);
    }

    private int solve(int i, int j, int n, int m, ArrayList<ArrayList<Integer>> a,
                      int[][] mem) {
        if (i == n) {
            return 0;
        }
        if (j > m) {
            return Integer.MAX_VALUE / 2;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        int choice1 = a.get(i).get(j) + solve(i + 1, j, n, m + 1, a, mem);
        int choice2 = a.get(i).get(j) + solve(i + 1, j + 1, n, m + 1, a, mem);
        return mem[i][j] = Math.min(choice1, choice2);
    }
}
