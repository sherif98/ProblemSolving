package strings;

public class MinimumCharsForPalindrome {

    public int solve(String s) {
        String pattern = String.join("@", s, new StringBuilder(s).reverse().toString());
        int[] failure = new int[pattern.length()];
        for (int i = 1, k = 0; i < pattern.length(); i++) {
            while (k > 0 && pattern.charAt(i) != pattern.charAt(k)) {
                k = failure[k - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(k)) {
                failure[i] = ++k;
            } else {
                failure[i] = k;
            }
        }
        return s.length() - failure[failure.length - 1];
    }
}
