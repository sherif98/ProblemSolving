package strings;

public class IsPalindrome {

    public int isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            char left = s.charAt(lo);
            if (!Character.isLetterOrDigit(left) || Character.isSpace(left)) {
                lo++;
                continue;
            }
            char right = s.charAt(hi);
            if (!Character.isLetterOrDigit(right) || Character.isSpace(right)) {
                hi--;
                continue;
            }
            if (Character.toLowerCase(left) != Character.toLowerCase(right)) {
                return 0;
            }
            lo++;
            hi--;
        }
        return 1;
    }
}
