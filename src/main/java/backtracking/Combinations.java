package backtracking;

import java.util.ArrayList;

public class Combinations {

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        solve(ret, new ArrayList<>(), A, B, 1);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p,
                       int n, int k, int i) {
        if (p.size() == k) {
            ret.add(new ArrayList<>(p));
            return;
        }
        if (i > n) {
            return;
        }
        for (int j = i; j <= n; j++) {
            p.add(j);
            solve(ret, p, n, k, j + 1);
            p.remove(p.size() - 1);
        }
    }
}
