package hashes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Equal {


    public static void main(String[] args) {
        Equal equal = new Equal();
        ArrayList<Integer> equal1 =
                equal.equal(new ArrayList<>(Arrays.asList(9, 5, 4, 9, 3, 6, 8, 7, 1, 2, 8, 7, 2, 9, 7, 1, 3, 9, 7, 8, 1, 0, 5, 5)));
        System.out.println(equal1);
    }

    public ArrayList<Integer> equal(ArrayList<Integer> nums) {
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i <= nums.size() - 4; i++) {
            for (int j = i + 1; j < nums.size(); j++) {
                int sum = nums.get(i) + nums.get(j);
                Map<Integer, Integer> map = new HashMap<>();
                int cFound = -1;
                for (int k = i + 1; k < nums.size(); k++) {
                    if (k == j) {
                        continue;
                    }
                    int num = nums.get(k);
                    if (map.containsKey(sum - num)) {
                        int c = map.get(sum - num);
                        if (cFound == -1 || cFound > c) {
                            cFound = c;
                            int d = k;
                            ret = new ArrayList<>();
                            ret.add(i);
                            ret.add(j);
                            ret.add(c);
                            ret.add(d);
                        }
                    } else {
                        if (!map.containsKey(num)) {
                            map.put(num, k);
                        }
                    }
                }
                if (cFound != -1) {
                    return ret;
                }
            }
        }
        return ret;
    }
}
