package dp;

public class EditDistance {

    public int minDistance(String a, String b) {
        int[][] mem = new int[a.length()][b.length()];
        for (int[] ar : mem) {
            Arrays.fill(ar, -1);
        }
        return solve(0, 0, a, b, mem);
    }

    private int solve(int i, int j, String a, String b, int[][] mem) {
        if (i == a.length()) {
            return b.length() - j;
        }
        if (j == b.length()) {
            return a.length() - i;
        }
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (a.charAt(i) == b.charAt(j)) {
            return solve(i + 1, j + 1, a, b, mem);
        }
        int choice1 = 1 + solve(i + 1, j, a, b, mem);
        int choice2 = 1 + solve(i, j + 1, a, b, mem);
        int choice3 = 1 + solve(i + 1, j + 1, a, b, mem);
        return mem[i][j] = Math.min(choice1, Math.min(choice2, choice3));
    }
}
