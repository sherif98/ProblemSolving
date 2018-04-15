package arrays;

import java.util.ArrayList;

public class AddOneToNumber {

    public ArrayList<Integer> plusOne(ArrayList<Integer> num) {
        int carry = 1;
        for (int i = num.size() - 1; i >= 0; i--) {
            int n = num.get(i);
            if (n < 9) {
                num.set(i, n + 1);
                carry = 0;
                break;
            } else if (n == 9) {
                num.set(i, 0);
            }
        }
        if (carry == 1) {
            ArrayList<Integer> ret = new ArrayList<>();
            ret.add(1);
            for (int i = 0; i < num.size(); i++) {
                ret.add(0);
            }
            return ret;
        }
        if (!num.isEmpty() && num.get(0) == 0) {
            int j = 0;
            while (j < num.size() && num.get(j++) == 0) ;
            ArrayList<Integer> ret = new ArrayList<>();
            for (int i = j - 1; i < num.size(); i++) {
                ret.add(num.get(i));
            }
            return ret;
        }
        return num;
    }
}
