package arrays;

import java.util.ArrayList;

public class PascalTriangle {

    public ArrayList<ArrayList<Integer>> generate(int n) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            ArrayList<Integer> cur = new ArrayList<>();
            for(int j = 0; j < i + 1; j++) {
                if(i == 0) {
                    cur.add(1);
                } else {
                    ArrayList<Integer> prev = ret.get(i - 1);
                    int num = 0;
                    if(j < prev.size()) {
                        num += prev.get(j);
                    }
                    if(j - 1 >= 0) {
                        num += prev.get(j - 1);
                    }
                    cur.add(num);
                }
            }
            ret.add(cur);
        }
        return ret;
    }
}
