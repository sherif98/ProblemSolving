package dp;

import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequenceTwo {


    public int longestSubsequenceLength(final List<Integer> A) {
        int[][] inc = new int[A.size()][A.size()];
        for (int[] a : inc) {
            Arrays.fill(a, -1);
        }
        int[][] dec = new int[A.size()][A.size()];
        for (int[] a : dec) {
            Arrays.fill(a, -1);
        }
        inc(0, 0, A, inc);
        dec(0, 0, A, dec);
        //TODO
        return 0;
    }

    private int inc(int i, int prev, List<Integer> nums, int[][] mem) {
        if (i == nums.size()) {
            return 0;
        }
        if (mem[i][prev] != -1) {
            return mem[i][prev];
        }
        int choice1 = 0;
        int choice2 = 0;
        if (i == prev) {
            choice1 = inc(i + 1, i + 1, nums, mem);
        } else {
            choice1 = inc(i + 1, prev, nums, mem);
        }
        if (i == prev || nums.get(i) > nums.get(prev)) {
            choice2 = 1 + inc(i + 1, i, nums, mem);
        }
        return mem[i][prev] = Math.max(choice1, choice2);
    }

    private int dec(int i, int prev, List<Integer> nums, int[][] mem) {
        if (i == nums.size()) {
            return 0;
        }
        if (mem[i][prev] != -1) {
            return mem[i][prev];
        }
        int choice1 = 0;
        int choice2 = 0;
        if (i == prev) {
            choice1 = dec(i + 1, i + 1, nums, mem);
        } else {
            choice1 = dec(i + 1, prev, nums, mem);
        }
        if (i == prev || nums.get(i) < nums.get(prev)) {
            choice2 = 1 + dec(i + 1, i, nums, mem);
        }
        return mem[i][prev] = Math.max(choice1, choice2);
    }
}
