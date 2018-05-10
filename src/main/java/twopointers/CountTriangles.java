package twopointers;

import java.util.ArrayList;
import java.util.Collections;

public class CountTriangles {

    public int nTriang(ArrayList<Integer> nums) {
        int cnt = 0;
        Collections.sort(nums);
        for (int i = 0; i < nums.size() - 2; i++) {
            int k = i + 2;
            for (int j = i + 1; j < nums.size(); j++) {
                while (k < nums.size() && nums.get(i) + nums.get(j) > nums.get(k)) {
                    k++;
                }
                cnt += k - j - 1;
                if (cnt >= 1000000007) {
                    cnt = cnt % 1000000007;
                }
            }
        }
        return cnt;
    }
}
