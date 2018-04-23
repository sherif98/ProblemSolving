package maths;

public class PalindromeInteger {

    public int isPalindrome(int n) {
        if (n < 0) {
            return 0;
        }
        int num = n;
        int ans = 0;
        while (num > 0) {
            int x = num % 10;
            num /= 10;
            int prev = ans;
            ans *= 10;
            if (ans / 10 != prev) {
                return 0;
            }
            ans += x;
        }
        if (ans == n) {
            return 1;
        }
        return 0;
    }
}
