package hashes;

import java.util.*;

public class PointOnStraightLineTwo {

    public int maxPoints(ArrayList<Integer> x, ArrayList<Integer> y) {
        if (x.size() <= 2) {
            return x.size();
        }
        List<Point> points = new ArrayList<>();
        for (int i = 0; i < x.size(); i++) {
            points.add(new Point(x.get(i), y.get(i)));
        }
        Map<Line, Integer> map = new HashMap<>();
        for (int i = 0; i < points.size(); i++) {
            for (int j = 0; j < points.size(); j++) {
                if (i == j) continue;
                double slope = calc(points.get(i), points.get(j));
                Line line = new Line(slope, points.get(i));
                map.merge(line, 1, Integer::sum);
            }
        }
        int max = 0;
        for (int n : map.values()) {
            max = Math.max(max, n);
        }
        if (map.isEmpty()) {
            return 0;
        }
        return max + 1;
    }

    private double calc(Point a, Point b) {
        int xDiff = b.x - a.x;
        if (xDiff == 0) {
            return Double.POSITIVE_INFINITY;
        }
        int yDiff = b.y - a.y;
        return (double) yDiff / xDiff;
    }

    class Line {
        double slope;
        Point point;

        Line(double slope, Point point) {
            this.slope = slope;
            this.point = point;
        }

        @Override
        public boolean equals(Object a) {
            if (a == null) {
                return false;
            }
            if (this == a) {
                return true;
            }
            if (!(a instanceof Line)) {
                return false;
            }
            Line other = (Line) a;
            return Double.compare(this.slope, other.slope) == 0 && this.point.equals(other.point);
        }

        @Override
        public int hashCode() {
            return Objects.hash(slope, point);
        }
    }

    class Point {
        int x;
        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object a) {
            if (a == null) {
                return false;
            }
            if (a == this) {
                return true;
            }
            if (!(a instanceof Point)) {
                return false;
            }
            Point other = (Point) a;
            return this.x == other.x && this.y == other.y;
        }
    }
}
