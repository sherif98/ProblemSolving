package dp;

import java.util.Arrays;
import java.util.List;

public class LengthOfLongestSubsequenceOne {

    public int longestSubsequenceLength(final List<Integer> A) {
        int[][][] mem = new int[A.size()][A.size()][2];
        for (int[][] f : mem) {
            for (int[] s : f) {
                Arrays.fill(s, -1);
            }
        }
        return solve(0, 0, true, A, mem);
    }

    private int solve(int i, int prev, boolean up, List<Integer> nums, int[][][] mem) {
        if (i == nums.size()) {
            return 0;
        }
        int take = 0;
        if (mem[i][prev][up ? 1 : 0] != -1) {
            return mem[i][prev][up ? 1 : 0];
        }
        if (up) {
            if (i == prev) {
                take = 1 + solve(i + 1, i, true, nums, mem);
            }
            if (nums.get(i) > nums.get(prev)) {
                take = 1 + solve(i + 1, i, true, nums, mem);
            } else if (nums.get(i) < nums.get(prev)) {
                take = 1 + solve(i + 1, i, false, nums, mem);
            }
        } else {
            if (nums.get(i) < nums.get(prev)) {
                take = 1 + solve(i + 1, i, false, nums, mem);
            }
        }
        int leave;
        if (i == prev) {
            leave = solve(i + 1, i + 1, up, nums, mem);
        } else {
            leave = solve(i + 1, prev, up, nums, mem);
        }
        return mem[i][prev][up ? 1 : 0] = Math.max(take, leave);
    }
}
