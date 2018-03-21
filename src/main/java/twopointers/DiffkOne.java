package twopointers;

import java.util.ArrayList;

public class DiffkOne {

    public int diffPossible(ArrayList<Integer> A, int B) {
        int lo = 0;
        int hi = 1;
        if (A.size() < 1) {
            return 0;
        }
        while (hi < A.size()) {
            if (lo == hi) {
                hi++;
                continue;
            }
            if (A.get(hi) - A.get(lo) == B) {
                return 1;
            } else if (A.get(hi) - A.get(lo) < B) {
                hi++;
            } else {
                lo++;
            }
        }
        return 0;
    }
}
