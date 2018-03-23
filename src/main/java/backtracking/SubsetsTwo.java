package backtracking;

import java.util.ArrayList;
import java.util.Collections;

public class SubsetsTwo {

    public ArrayList<ArrayList<Integer>> subsetsWithDup(ArrayList<Integer> A) {
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
            if (idx > i && nums.get(idx).equals(nums.get(idx - 1))) {
                continue;
            }
            p.add(nums.get(idx));
            solve(ret, p, idx + 1, nums);
            p.remove(p.size() - 1);
        }
    }
}
