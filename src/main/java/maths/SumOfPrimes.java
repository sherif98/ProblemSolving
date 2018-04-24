package maths;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfPrimes {

    public ArrayList<Integer> primesum(int n) {
        Sieve sieve = new Sieve(n);
        for (int p : sieve.getPrimes(n)) {
            int other = n - p;
            if (sieve.isPrime(other)) {
                return new ArrayList<>(Arrays.asList(p, other));
            }
        }
        return new ArrayList<>();
    }

    class Sieve {
        private boolean[] isPrime;

        Sieve(int n) {
            isPrime = new boolean[n + 1];
            preProcessPrimes(n);
        }

        private void preProcessPrimes(int n) {
            isPrime[0] = isPrime[1] = true;
            for (int i = 2; i * i <= n; i++) {
                if (!isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }
        }

        public boolean isPrime(int n) {
            return !isPrime[n];
        }

        public Iterable<Integer> getPrimes(int n) {
            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                if (!isPrime[i]) {
                    ans.add(i);
                }
            }
            return ans;
        }
    }
}
