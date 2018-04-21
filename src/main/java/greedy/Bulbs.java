package greedy;

import java.util.ArrayList;

public class Bulbs {

    public int bulbs(ArrayList<Integer> nums) {
        int add = 0;
        int ans = 0;
        for (int n : nums) {
            if ((n + add) % 2 == 0) {
                ans++;
                add = (add + 1) % 2;
            }
        }
        return ans;
    }
}
