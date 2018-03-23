package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class CombinationSum {

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> A, int B) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        A = A.stream().distinct().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(A);
        solve(ret, new ArrayList<>(), A, B, 0, 0);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p,
                       ArrayList<Integer> nums, int target, int i, int sum) {
        if (sum == target) {
            ret.add(new ArrayList<>(p));
            return;
        }
        if (i >= nums.size() || sum > target) {
            return;
        }
        for (int j = i; j < nums.size(); j++) {
            if (sum + nums.get(j) > target) {
                break;
            }
            p.add(nums.get(j));
            solve(ret, p, nums, target, j, sum + nums.get(j));
            p.remove(p.size() - 1);
        }
    }
}
