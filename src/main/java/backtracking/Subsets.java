package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class Subsets {

    public ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Collections.sort(A);
        solve(ret, new ArrayList<>(), 0, A);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p,
                       int i, ArrayList<Integer> nums) {
        ret.add(new ArrayList<>(p));
        if (i == nums.size()) {
            return;
        }
        for (int idx = i; idx < nums.size(); idx++) {
            p.add(nums.get(idx));
            solve(ret, p, idx + 1, nums);
            p.remove(p.size() - 1);
        }
    }
}
