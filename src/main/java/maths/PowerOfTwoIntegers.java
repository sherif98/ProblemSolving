package maths;

import java.util.ArrayList;
import java.util.List;

public class PowerOfTwoIntegers {

    public static void main(String[] args) {
        PowerOfTwoIntegers powerOfTwoIntegers = new PowerOfTwoIntegers();
        int power = powerOfTwoIntegers.isPower(20736);
        System.out.println(power);
    }


    public int isPower(int n) {
        if ((int) Math.sqrt(n) * (int) Math.sqrt(n) == n) {
            return 1;
        }
        Sieve sieve = new Sieve();
        List<Integer> freq = new ArrayList<>();
        List<Integer> primes = sieve.getPrimes();
        int idx = 0;
        int smallestCnt = -1;
        int highestCnt = 0;
        while (n != 1) {
            int cnt = 0;
            while (n % primes.get(idx) == 0) {
                cnt++;
                n /= primes.get(idx);
            }
            if (cnt != 0) {
                if (smallestCnt == -1 || cnt < smallestCnt) {
                    smallestCnt = cnt;
                }
                highestCnt = Math.max(highestCnt, cnt);
                freq.add(cnt);
            }

            idx++;
        }
        if (highestCnt == 1 || smallestCnt == 1) {
            return 0;
        }
        for (int f : freq) {
            if (f % smallestCnt != 0) {
                return 0;
            }
        }
        return 1;
    }

    class Sieve {

        private boolean[] isPrime;

        Sieve() {
            int n = (int) 1e6;
            isPrime = new boolean[n + 1];
            isPrime[0] = isPrime[1] = true;
            findPrimes(n);
        }

        private void findPrimes(int n) {
            for (int i = 2; i * i <= n; i++) {
                if (!isPrime[i]) {
                    for (int j = i * i; j <= n; j += i) {
                        isPrime[j] = true;
                    }
                }
            }
        }

        public List<Integer> getPrimes() {
            List<Integer> primes = new ArrayList<>();
            for (int i = 2; i < isPrime.length; i++) {
                if (!isPrime[i]) {
                    primes.add(i);
                }
            }
            return primes;
        }

    }
}
