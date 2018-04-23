package maths;

public class IsPrime {


    public int isPrime(int n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) {
            if (n % i == 0) {
                return 0;
            }
        }
        return 1;
    }
}
