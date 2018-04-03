package twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class FourSum {

    public ArrayList<ArrayList<Integer>> fourSum(ArrayList<Integer> nums, int target) {
        Collections.sort(nums);
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < nums.size(); i++) {
            if(i > 0 && nums.get(i - 1).equals(nums.get(i))) {
                continue;
            }
            for(int j = i + 1; j < nums.size(); j++) {
                if(j > i + 1 && nums.get(j - 1).equals(nums.get(j))) {
                    continue;
                }
                int t = target -  (nums.get(i) + nums.get(j));
                int lo = j + 1;
                int hi = nums.size() - 1;
                while(lo < hi) {
                    if(nums.get(lo) + nums.get(hi) == t) {
                        ArrayList<Integer> p = new ArrayList<>();
                        p.add(nums.get(i));
                        p.add(nums.get(j));
                        p.add(nums.get(lo));
                        p.add(nums.get(hi));
                        ret.add(p);
                        lo++;
                        hi--;
                        while(lo < hi && nums.get(lo - 1).equals(nums.get(lo))) {
                            lo++;
                        }
                        while(hi > lo && nums.get(hi).equals(nums.get(hi + 1))) {
                            hi--;
                        }
                    } else if(nums.get(lo) + nums.get(hi) > t) {
                        hi--;
                    }else {
                        lo++;
                    }
                }
            }
        }
        return ret;
    }
}
