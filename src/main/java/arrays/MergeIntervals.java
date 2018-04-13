package arrays;

import java.util.ArrayList;

public class MergeIntervals {

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ret = new ArrayList<>();
        newInterval.start = Math.min(newInterval.start, newInterval.end);
        newInterval.end = Math.max(newInterval.start, newInterval.end);

        for (Interval current : intervals) {
            if (newInterval != null) {
                if (intersects(current, newInterval)) {
                    newInterval = merge(current, newInterval);
                } else {
                    if (newInterval.end < current.start) {
                        ret.add(newInterval);
                        newInterval = null;
                    }
                    ret.add(current);
                }
            } else {
                ret.add(current);
            }
        }
        if (newInterval != null) {
            ret.add(newInterval);
        }
        return ret;
    }

    private boolean intersects(Interval one, Interval two) {
        return two.start <= one.end && two.end >= one.start;
    }

    private Interval merge(Interval one, Interval two) {
        int start = Math.min(one.start, two.start);
        int end = Math.max(one.end, two.end);
        return new Interval(start, end);
    }

    class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
