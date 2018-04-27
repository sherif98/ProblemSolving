package greedy;

import java.util.ArrayList;
import java.util.Arrays;

public class DistributeCandyTwo {

    public int candy(ArrayList<Integer> nums) {
        int n = nums.size();
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for (int i = 0; i < n - 1; i++) {
            if (nums.get(i + 1) > nums.get(i)) {
                candies[i + 1] = candies[i] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (nums.get(i - 1) > nums.get(i) && candies[i - 1] <= candies[i]) {
                candies[i - 1] = candies[i] + 1;
            }
        }
        return Arrays.stream(candies).sum();
    }

}
