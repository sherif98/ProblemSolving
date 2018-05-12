package binary.search;

public class ImplementPowerFunction {


    public int pow(int x, int n, int d) {
        return (int) solve(x, n, d);
    }

    private long solve(long x, long n, long d) {
        if (x == 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (n % 2 == 0) {
            long ans = Math.floorMod(solve(x, n / 2, d), d);
            return Math.floorMod(Math.multiplyExact(ans, ans), d);
        } else {
            long ans = Math.floorMod(solve(x, n / 2, d), d);
            long z = Math.floorMod(x, d);
            long a = Math.floorMod(Math.multiplyExact(ans, ans), d);
            return Math.floorMod(Math.multiplyExact(a, Math.floorMod(z, d)), d);
        }
    }
}
