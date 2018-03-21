package twopointers;

import java.util.ArrayList;

public class SortColors {

    public void sortColors(ArrayList<Integer> a) {
        int zeros = 0;
        int ones = 0;
        int twos = 0;
        for (int n : a) {
            if (n == 0) {
                zeros++;
            } else if (n == 1) {
                ones++;
            } else {
                twos++;
            }
        }
        for (int i = 0; i < a.size(); i++) {
            if (zeros > 0) {
                a.set(i, 0);
                zeros--;
            } else if (ones > 0) {
                a.set(i, 1);
                ones--;
            } else {
                a.set(i, 2);
            }
        }
    }
}
