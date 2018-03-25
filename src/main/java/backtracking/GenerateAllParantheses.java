package backtracking;

import java.util.ArrayList;

public class GenerateAllParantheses {

    public ArrayList<String> generateParenthesis(int A) {
        ArrayList<String> ret = new ArrayList<>();
        solve(ret, "", A, 0, 0);
        return ret;
    }

    private void solve(ArrayList<String> ret, String p, int n, int cnt, int i) {
        if (cnt < 0) {
            return;
        }
        if (i == 2 * n) {
            if (cnt == 0) {
                ret.add(p);
            }
            return;
        }
        solve(ret, p + "(", n, cnt + 1, i + 1);
        solve(ret, p + ")", n, cnt - 1, i + 1);
    }
}
