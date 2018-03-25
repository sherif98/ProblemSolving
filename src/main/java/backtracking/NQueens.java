package backtracking;

import java.util.ArrayList;

public class NQueens {

    public ArrayList<ArrayList<String>> solveNQueens(int a) {
        ArrayList<ArrayList<String>> ret = new ArrayList<>();
        solve(ret, 0, a, new int[a]);
        return ret;
    }

    private void solve(ArrayList<ArrayList<String>> ret, int i, int n, int[] plays) {
        if (i == n) {
            ret.add(convertPlay(plays));
            return;
        }
        //i row
        //j column
        for (int j = 0; j < n; j++) {
            if (isSafe(plays, i, j)) {
                plays[i] = j;
                solve(ret, i + 1, n, plays);
            }
        }
    }

    private boolean isSafe(int[] plays, int row, int column) {
        for (int i = 0; i < row; i++) {
            if (Math.abs(column - plays[i]) == row - i) {
                return false;
            }
            if (column == plays[i]) {
                return false;
            }
        }
        return true;
    }

    private ArrayList<String> convertPlay(int[] plays) {
        ArrayList<String> ret = new ArrayList<>();
        for (int k = 0; k < plays.length; k++) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < plays.length; i++) {
                if (plays[k] == i) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            ret.add(sb.toString());
        }
        return ret;
    }
}
