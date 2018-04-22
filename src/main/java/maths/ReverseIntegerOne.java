package maths;

public class ReverseIntegerOne {

    public int reverse(int n) {
        boolean neg = n < 0;
        long num = n;
        if (neg) {
            num *= -1;
        }
        long ans = 0;
        while (num != 0) {
            long x = num % 10;
            num /= 10;
            ans *= 10;
            ans += x;
        }
        if (neg) {
            ans *= -1;
        }
        if (ans > Integer.MAX_VALUE || ans < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) ans;
    }

}
