package arrays;

import java.util.ArrayList;
import java.util.Collections;

public class KthRowPascalTriangle {

    public ArrayList<Integer> getRow(int k) {
        ArrayList<Integer> prev = new ArrayList<>(Collections.singletonList(1));
        ArrayList<Integer> current = new ArrayList<>();
        if (k == 0) {
            return prev;
        }
        for (int j = 1; j <= k; j++) {
            current = new ArrayList<>();
            for (int i = 0; i <= j; i++) {
                if (i == 0 || i == j) {
                    current.add(1);
                } else {
                    int n = prev.get(i - 1) + prev.get(i);
                    current.add(n);
                }
            }
            prev = current;
        }
        return current;
    }
}
