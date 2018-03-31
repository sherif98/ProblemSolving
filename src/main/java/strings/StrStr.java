package strings;

public class StrStr {

    public int strStr(final String s, final String pattern) {
        if (pattern.length() == 0 || s.length() == 0) {
            return -1;
        }
        int[] failure = computeFailureFn(pattern);
        for (int i = 0, k = 0; i < s.length(); i++) {
            while (k > 0 && s.charAt(i) != pattern.charAt(k)) {
                k = failure[k - 1];
            }
            if (s.charAt(i) == pattern.charAt(k)) {
                k++;
            }
            if (k == pattern.length()) {
                return i - k + 1;
            }
        }
        return -1;
    }

    private int[] computeFailureFn(String pattern) {
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
        return failure;
    }
}
