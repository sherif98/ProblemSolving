package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class HighestProduct {

    public int maxp3(ArrayList<Integer> nums) {
        Collections.sort(nums);
        int n = nums.size();
        int lastThree = nums.get(n - 1) * nums.get(n - 2) * nums.get(n - 3);
        int lastOneAndFirstTwo = nums.get(0) * nums.get(1) * nums.get(n - 1);
        return Math.max(lastThree, lastOneAndFirstTwo);
    }
}
