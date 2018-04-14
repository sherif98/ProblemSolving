package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RepeatedAndMissingNumberTwo {

    public ArrayList<Integer> repeatedNumber(final List<Integer> nums) {
        long sum = 0;
        long squareSum = 0;
        long n = nums.size();
        long realSum = (n * (n - 1) / 2 + n);
        for (long num : nums) {
            sum += num;
            squareSum += (num * num);
        }
        long realSquareSum = 0;
        for (long i = 1; i <= n; i++) {
            realSquareSum += (i * i);
        }
        long sumDiff = sum - realSum;
        long squareSumDiff = squareSum - realSquareSum;
        long div = squareSumDiff / sumDiff;
        int a = (int) (div + sumDiff) / 2;
        int b = (int) div - a;
        return new ArrayList<>(Arrays.asList(a, b));
    }

}
