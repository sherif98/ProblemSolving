package greedy;

import java.util.ArrayList;
import java.util.List;

public class Seats {

    public static void main(String[] args) {
        Seats seats = new Seats();
        int ans = seats.seats(".xxx");
        System.out.println(ans);
    }

    public int seats(String row) {
        List<Integer> seats = new ArrayList<>();
        long ans = 0;
        for (int i = 0; i < row.length(); i++) {
            if (row.charAt(i) == 'x') {
                seats.add(i);
            }
        }
        int size = seats.size();
        if (size == 0) {
            return 0;
        }
        int median;
        int below = 0;
        int above = 0;
        int lo = 0;
        int hi = 0;
        if (size % 2 == 0) {
            below = size / 2 - 1;
            above = size / 2;
            median = (seats.get(size / 2) + seats.get(size / 2 - 1)) / 2;
            lo = median;
            hi = median + 1;
        } else {
            below = size / 2 - 1;
            above = size / 2 + 1;
            median = seats.get(size / 2);
            lo = median - 1;
            hi = median + 1;
        }
        for (int i = below; i >= 0; i--) {
            ans += lo - seats.get(i);
            ans %= 10000003;
            lo--;
        }
        for (int i = above; i < seats.size(); i++) {
            ans += seats.get(i) - hi;
            ans %= 10000003;
            hi++;
        }
        return (int) ans;
    }
}
