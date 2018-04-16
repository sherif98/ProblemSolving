package twopointers;

import java.util.ArrayList;

public class MaxContinousSeriesOfOnes {

    public ArrayList<Integer> maxone(ArrayList<Integer> nums, int m) {
        int i = 0;
        int j = 0;
        int max = 0;
        int start = -1;
        int left = m;
        while (j < nums.size()) {
            while (j < nums.size() && (nums.get(j) == 1 || left > 0)) {
                if (nums.get(j) == 0) {
                    left--;
                }
                j++;
            }
            if (j - i > max) {
                max = j - i;
                start = i;
            }
            while (i < j) {
                if (nums.get(i) == 0) {
                    i++;
                    left++;
                    break;
                }
                i++;
            }
            if (left == 0) {
                i++;
                j++;
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int k = start; k < start + max; k++) {
            ans.add(k);
        }
        return ans;
    }
}
