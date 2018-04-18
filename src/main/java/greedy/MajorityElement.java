package greedy;

import java.util.List;

public class MajorityElement {

    public int majorityElement(final List<Integer> nums) {
        int number = nums.get(0);
        int cnt = 0;
        for (int n : nums) {
            if (n == number) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    number = n;
                    cnt = 1;
                }
            }
        }
        return number;
    }
}
