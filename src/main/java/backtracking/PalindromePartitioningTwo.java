package backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class PalindromePartitioningTwo {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ret = new ArrayList<>();
        int[][] isPalindrome = new int[a.length() + 1][a.length() + 1];
        for (int[] x : isPalindrome) {
            Arrays.fill(x, -1);
        }
        solve(ret, new ArrayList<>(), 0, a, 0, 0, isPalindrome);
        return ret;
    }

    private void solve(ArrayList<ArrayList<String>> ret, ArrayList<String> p, int i, String a,
                       int lo, int hi, int[][] isPalindrome) {
        if (i == a.length()) {
            if (lo < hi) {
                if (isPalindrome(a, lo, hi - 1, isPalindrome) == 0) {
                    return;
                }
                p.add(a.substring(lo, hi));
            }
            ret.add(new ArrayList<>(p));
            return;
        }
        for (int j = i; j < a.length(); j++) {
            hi++;
            if (isPalindrome(a, lo, hi - 1, isPalindrome) == 1) {
                p.add(a.substring(lo, hi));
                solve(ret, p, j + 1, a, hi, hi, isPalindrome);
                p.remove(p.size() - 1);
            }
        }
    }

    private int isPalindrome(String a, int lo, int hi, int[][] isPalindrome) {
        if (lo == hi) {
            return isPalindrome[lo][hi] = 1;
        }
        if (lo > hi) {
            return 1;
        }
        if (isPalindrome[lo][hi] != -1) {
            return isPalindrome[lo][hi];
        }
        return isPalindrome[lo][hi] = a.charAt(lo) == a.charAt(hi) &&
                isPalindrome(a, lo + 1, hi - 1, isPalindrome) == 1 ? 1 : 0;

    }
}
