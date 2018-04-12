package dp;

import java.util.Arrays;

public class WaysToDecodeTwo {

    public int numDecodings(String A) {
        if(A.length() == 1 && A.charAt(0) == '0') {
            return 0;
        }
        if(!A.isEmpty() && A.charAt(0) == '0') {
            return 0;
        }
        int[] mem = new int[A.length() + 1];
        Arrays.fill(mem, -1);
        return solve(0, A, mem);
    }

    private int solve(int i, String a, int[] mem) {
        if(i == a.length() || i == a.length() - 1) {
            return 1;
        }
        if(mem[i] != -1) {
            return mem[i];
        }
        int ret = 0;
        if(a.charAt(i) > '0' && a.charAt(i + 1) != '0') {
            ret += solve(i + 1, a, mem);
        }
        if(a.charAt(i) == '1') {
            ret += solve(i + 2, a, mem);
        }
        if(a.charAt(i) == '2' && a.charAt(i + 1) < '7') {
            ret += solve(i + 2, a, mem);
        }
        return mem[i] = ret;
    }
}
