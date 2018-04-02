package twopointers;

import java.util.*;

public class ThreeSumZero {

    public static void main(String[] args) {
        ThreeSumZero threeSumZero = new ThreeSumZero();
        ArrayList<ArrayList<Integer>> arrayLists = threeSumZero.threeSum(new ArrayList<>(Arrays.asList(2, 1, 0, -1, -1, -4)));
        System.out.println(arrayLists);
    }

    public ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> a) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            if (i > 0 && a.get(i - 1).equals(a.get(i))) {
                continue;
            }
            twoSum(a, i, ret);
        }
        return ret;
    }

    private void twoSum(List<Integer> nums, int idx, ArrayList<ArrayList<Integer>> ret) {
        int lo = idx + 1;
        int hi = nums.size() - 1;
        int target = -1 * nums.get(idx);
        while (lo < hi) {
            if (nums.get(lo) + nums.get(hi) == target) {
                ArrayList<Integer> p =
                        new ArrayList<>(Arrays.asList(-target, nums.get(lo), nums.get(hi)));
                ret.add(p);
                lo++;
                hi--;
                while (lo < hi && nums.get(lo - 1).equals(nums.get(lo))) {
                    lo++;
                }
                while (hi < nums.size() - 1 && nums.get(hi + 1).equals(nums.get(hi))) {
                    hi--;
                }
            } else if (nums.get(lo) + nums.get(hi) > target) {
                hi--;
            } else {
                lo++;
            }
        }
    }
}
