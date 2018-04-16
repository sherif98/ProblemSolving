package hashes;

import java.util.*;

public class PointOnStraightLineOne {

    public static void main(String[] args) {
        PointOnStraightLineOne line = new PointOnStraightLineOne();
        int i = line.maxPoints(new ArrayList<>(Arrays.asList(4, 8, -4)),
                new ArrayList<>(Arrays.asList(-4, -4, -4)));
        System.out.println(i);
    }

    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.size() <= 2) {
            return x.size();
        }
        int ans = 0;
        for (int i = 0; i < x.size(); i++) {
            Map<Double, Integer> map = new HashMap<>();
            for (int j = 0; j < x.size(); j++) {
                if (i == j) continue;
                double slope = calc(x.get(i), y.get(i), x.get(j), y.get(j));
                map.merge(slope, 1, Integer::sum);
            }
            for (int n : map.values()) {
                ans = Math.max(ans, n);
            }
        }
        return ans + 1;
    }

    private double calc(int x1, int y1, int x2, int y2) {
        int xDiff = x2 - x1;
        if (xDiff == 0) {
            return Double.POSITIVE_INFINITY;
        }
        double yDiff = y2 - y1;
        return yDiff / xDiff;
    }
}
