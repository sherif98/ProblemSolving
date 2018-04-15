package arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class Flip {

    public ArrayList<Integer> flip(String s) {
        int maxEndingHere = 0;
        int maxSoFar = 0;
        int start = -1;
        int end = -1;
        int tempStart = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                maxEndingHere++;
            }
            if (s.charAt(i) == '1') {
                maxEndingHere--;
            }
            if (maxEndingHere > maxSoFar) {
                maxSoFar = maxEndingHere;
                start = tempStart;
                end = i;
            }
            if (maxEndingHere < 0) {
                maxEndingHere = 0;
                tempStart = i + 1;
            }
        }
        if (start != -1) {
            return new ArrayList<>(Arrays.asList(start + 1, end + 1));
        }
        return new ArrayList<>();
    }
}
