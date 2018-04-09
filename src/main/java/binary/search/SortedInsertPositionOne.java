package binary.search;

import java.util.ArrayList;
import java.util.Collections;

public class SortedInsertPositionOne {


    public int searchInsert(ArrayList<Integer> a, int b) {
        int x = Collections.binarySearch(a, b);
        if(x < 0) {
            return -1 * (x + 1);
        }
        return x;
    }
}
