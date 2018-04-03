package heaps.maps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DistinctNumberInWindow {

    public ArrayList<Integer> dNums(ArrayList<Integer> nums, int k) {
        int lo = 0;
        int hi = k - 1;
        if (k > nums.size()) {
            return new ArrayList<>();
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < hi; i++) {
            map.merge(nums.get(i), 1, Integer::sum);
        }
        ArrayList<Integer> ret = new ArrayList<>();
        for (; hi < nums.size(); lo++, hi++) {
            map.merge(nums.get(hi), 1, Integer::sum);
            ret.add(map.size());
            map.merge(nums.get(lo), -1, Integer::sum);
            if (map.get(nums.get(lo)) == 0) {
                map.remove(nums.get(lo));
            }
        }
        return ret;
    }
}
