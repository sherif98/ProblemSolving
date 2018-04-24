package maths;

import java.util.ArrayList;

public class PrimeNumberSieve {

    public ArrayList<Integer> sieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true;
        for (int i = 2; i * i <= n; i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            if (!isPrime[i]) {
                primes.add(i);
            }
        }
        return primes;
    }
}
