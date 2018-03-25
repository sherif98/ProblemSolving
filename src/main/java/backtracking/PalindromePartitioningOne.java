package backtracking;

import java.util.ArrayList;

public class PalindromePartitioningOne {

    public ArrayList<ArrayList<String>> partition(String a) {
        ArrayList<ArrayList<String>> ret = new ArrayList<>();
        solve(ret, new ArrayList<>(), 0, a, new StringBuilder());
        return ret;
    }

    private void solve(ArrayList<ArrayList<String>> ret, ArrayList<String> p, int i, String a,
                       StringBuilder current) {
        if (i == a.length()) {
            if (current.length() != 0) {
                if (!isPalindrome(current.toString())) {
                    return;
                }
                p.add(current.toString());
            }
            ret.add(new ArrayList<>(p));
            return;
        }
        for (int j = i; j < a.length(); j++) {
            current.append(a.charAt(j));
            if (isPalindrome(current.toString())) {
                p.add(current.toString());
                solve(ret, p, j + 1, a, new StringBuilder());
                p.remove(p.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String a) {
        int lo = 0;
        int hi = a.length() - 1;
        while (lo < hi) {
            if (a.charAt(lo) != a.charAt(hi)) {
                return false;
            }
            lo++;
            hi--;
        }
        return true;
    }
}
