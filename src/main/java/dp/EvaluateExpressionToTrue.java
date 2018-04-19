package dp;

import java.util.Arrays;

public class EvaluateExpressionToTrue {

    public static void main(String[] args) {
        EvaluateExpressionToTrue evaluateExpressionToTrue = new EvaluateExpressionToTrue();
        int cnttrue = evaluateExpressionToTrue.cnttrue("F&F^T^F");
        System.out.println(cnttrue);
    }

    public int cnttrue(String a) {
        int[][] memTrues = new int[a.length()][a.length()];
        int[][] memFalses = new int[a.length()][a.length()];
        for (int[] ar : memTrues) {
            Arrays.fill(ar, -1);
        }
        for (int[] ar : memFalses) {
            Arrays.fill(ar, -1);
        }
        return solve(0, a.length() - 1, a, memTrues, memFalses).trues;
    }

    private TrueFalse solve(int i, int j, String a, int[][] memTrues, int[][] memFalses) {
        if (i == j) {
            if (a.charAt(i) == 'T') {
                return new TrueFalse(1, 0);
            }
            return new TrueFalse(0, 1);
        }
        if (memTrues[i][j] != -1) {
            return new TrueFalse(memTrues[i][j], memFalses[i][j]);
        }
        TrueFalse ret = new TrueFalse(0, 0);
        for (int k = i; k <= j; k++) {
            if (isOperator(a.charAt(k))) {
                TrueFalse left = solve(i, k - 1, a, memTrues, memFalses);
                TrueFalse right = solve(k + 1, j, a, memTrues, memFalses);
                TrueFalse cur = evaluate(a.charAt(k), left, right);
                ret.trues += cur.trues;
                ret.falses += cur.falses;
                ret.trues %= 1003;
                ret.falses %= 1003;
            }
        }
        memTrues[i][j] = ret.trues;
        memFalses[i][j] = ret.falses;
        return ret;
    }

    private boolean isOperator(char c) {
        return c == '|' || c == '&' || c == '^';
    }

    private TrueFalse evaluate(char operator, TrueFalse left, TrueFalse right) {
        int trues = 0;
        int falses = 0;
        if (operator == '|') {
            trues += left.trues * right.trues;
            trues += left.trues * right.falses;
            trues += left.falses * right.trues;
            falses += left.falses * right.falses;
        } else if (operator == '&') {
            trues += left.trues * right.trues;
            falses += left.falses * right.falses;
            falses += left.trues * right.falses;
            falses += left.falses * right.trues;
        } else {
            trues += left.trues * right.falses;
            trues += left.falses * right.trues;
            falses += left.falses * right.falses;
            falses += left.trues * right.trues;
        }
        return new TrueFalse(trues, falses);
    }

    class TrueFalse {
        int trues;
        int falses;

        TrueFalse(int trues, int falses) {
            this.trues = trues;
            this.falses = falses;
        }
    }
}
