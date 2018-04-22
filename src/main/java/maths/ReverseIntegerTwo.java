package maths;

public class ReverseIntegerTwo {

    public int reverse(int n) {
        boolean neg = n < 0;
        if (neg) {
            n *= -1;
        }
        int ans = 0;
        while (n != 0) {
            int x = n % 10;
            n /= 10;
            int prev = ans;
            ans *= 10;
            if (ans / 10 != prev) {
                return 0;
            }
            ans += x;
        }
        if (neg) {
            ans *= -1;
        }
        return ans;
    }
}
