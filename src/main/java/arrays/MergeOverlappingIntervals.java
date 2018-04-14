package arrays;

import java.util.ArrayList;

public class MergeOverlappingIntervals {

    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        ArrayList<Interval> ans = new ArrayList<>();
        Interval last = null;
        intervals.sort((a, b) -> {
            int cmp = a.start - b.start;
            if (cmp != 0) {
                return cmp;
            }
            return a.end - b.end;
        });
        for (int i = 0; i < intervals.size(); i++) {
            if (last == null) {
                ans.add(intervals.get(i));
                last = intervals.get(i);
            } else {
                if (intersect(last, intervals.get(i))) {
                    Interval current = intervals.get(i);
                    ans.remove(ans.size() - 1);
                    Interval merged = merge(last, current);
                    ans.add(merged);
                    last = merged;
                } else {
                    last = intervals.get(i);
                    ans.add(last);
                }
            }
        }
        return ans;
    }

    private boolean intersect(Interval one, Interval two) {
        return one.end >= two.start;
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
