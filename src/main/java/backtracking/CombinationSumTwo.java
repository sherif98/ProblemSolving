package backtracking;

import java.util.*;

public class CombinationSumTwo {

    public static void main(String[] args) {
        CombinationSumTwo combinationSumTwo = new CombinationSumTwo();
        ArrayList<ArrayList<Integer>> arrayLists = combinationSumTwo.combinationSum(new ArrayList<>(Arrays.asList(2, 2, 3, 6, 7)), 9);
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> combinationSum(ArrayList<Integer> a, int b) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Collections.sort(a);
        solve(ret, new ArrayList<>(), b, a, 0, 0);
        return ret;
    }

    private void solve(ArrayList<ArrayList<Integer>> ret, ArrayList<Integer> p,
                       int target, ArrayList<Integer> nums, int sum, int i) {
        if (target == sum) {
            ret.add(new ArrayList<>(p));
            return;
        }
        if (sum > target) {
            return;
        }
        if (i >= nums.size()) {
            return;
        }
        for (int j = i; j < nums.size(); j++) {
            if (j > i && nums.get(j).equals(nums.get(j - 1))) {
                continue;
            }
            p.add(nums.get(j));
            solve(ret, p, target, nums, sum + nums.get(j), j + 1);
            p.remove(p.size() - 1);
        }
    }
}
