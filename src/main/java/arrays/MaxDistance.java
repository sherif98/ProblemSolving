package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaxDistance {


    public int maximumGap(final List<Integer> nums) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            pairs.add(new Pair(nums.get(i), i));
        }
        pairs.sort((a, b) -> a.num - b.num);
        List<Integer> idxes = pairs.stream()
                .map(node -> node.idx)
                .collect(Collectors.toList());
        List<Integer> suffixMax = new ArrayList<>();
        int max = 0;
        for (int i = idxes.size() - 1; i >= 0; i--) {
            max = Math.max(max, idxes.get(i));
            suffixMax.add(max);
        }
        Collections.reverse(suffixMax);
        int ans = 0;
        for (int i = 0; i < idxes.size() - 1; i++) {
            int after = suffixMax.get(i + 1);
            ans = Math.max(ans, after - idxes.get(i));
        }
        return ans;
    }

    class Pair {
        int num;
        int idx;

        Pair(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
