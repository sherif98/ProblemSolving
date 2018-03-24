package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Permutations {

    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        solve(ret, new ArrayList<>(), A, new HashSet<>());
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p,
                       ArrayList<Integer> nums, Set<Integer> vis) {
        if (p.size() == nums.size()) {
            ret.add(new ArrayList<>(p));
            return;
        }
        for (int j = 0; j < nums.size(); j++) {
            if (!vis.contains(nums.get(j))) {
                vis.add(nums.get(j));
                p.add(nums.get(j));
                solve(ret, p, nums, vis);
                vis.remove(nums.get(j));
                p.remove(p.size() - 1);
            }
        }
    }
}
