package backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KthPermutationSeq {


    public static void main(String[] args) {
        KthPermutationSeq kthPermutationSeq = new KthPermutationSeq();
        System.out.println(kthPermutationSeq.kth(2, 1));
    }

    private String kth(int n, int k) {
        List<Integer> number = convertToFactoradic(k, n);
        StringBuilder sb = new StringBuilder();
        boolean[] cnt = new boolean[n];
        for (int a : number) {
            sb.append(getNumber(a, cnt));
        }
        return sb.toString();
    }

    private int getNumber(int a, boolean[] cnt) {
        int seen = 0;
        for (int i = 0; i < cnt.length; i++) {
            if (seen == a) {
                while (cnt[i]) {
                    i++;
                }
                cnt[i] = true;
                return i + 1;
            } else {
                if (!cnt[i]) {
                    seen++;
                }
            }
        }
        return cnt.length;
    }


    private List<Integer> convertToFactoradic(int n, int size) {
        List<Integer> ret = new ArrayList<>();
        int i = 1;
        while (n != 0) {
            ret.add(n % i);
            n /= i;
            i++;
        }
        while (ret.size() < size) {
            ret.add(0);
        }
        Collections.reverse(ret);
        return ret;
    }
}
