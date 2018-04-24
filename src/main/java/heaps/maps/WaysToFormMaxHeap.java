package heaps.maps;

import java.util.Arrays;

public class WaysToFormMaxHeap {

    public int solve(int n) {
        long[][] mem = new long[n + 1][n + 1];
        for (long[] a : mem) {
            Arrays.fill(a, -1);
        }
        long[] heapsMem = new long[n + 1];
        Arrays.fill(heapsMem, -1);
        return (int) (findNumberOfHeaps(n, mem, heapsMem) % 1000000007);
    }

    private long findNumberOfHeaps(int n, long[][] mem, long[] heapsMem) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (heapsMem[n] != -1) {
            return heapsMem[n];
        }
        int remaining = n - 1;
        int onLeft = 0;
        int height = (int) (Math.log(n) / Math.log(2));
        for (int h = 1; h <= height; h++) {
            onLeft += Math.min(Math.pow(2, h - 1), remaining);
            remaining -= Math.pow(2, h);
        }
        int onRight = n - 1 - onLeft;
        long lComb = comb(n - 1, onLeft, mem);
        return heapsMem[n] = ((lComb * findNumberOfHeaps(onLeft, mem, heapsMem) % 1000000007)
                * findNumberOfHeaps(onRight, mem, heapsMem)) % 1000000007;
    }

    private long comb(int n, int k, long[][] mem) {
        if (k == 0 || k == n) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        if (mem[n][k] != -1) {
            return mem[n][k];
        }
        return mem[n][k] = (comb(n - 1, k - 1, mem) + comb(n - 1, k, mem)) % 1000000007;
    }
}