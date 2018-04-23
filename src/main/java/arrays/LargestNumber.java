package arrays;

import java.util.List;
import java.util.stream.Collectors;

public class LargestNumber {


    public String largestNumber(final List<Integer> nums) {
        String ans = nums.stream().sorted((a, b) -> {
            String aBeforeB = "" + a + b;
            String bBeforeA = "" + b + a;
            long cmp = Long.parseLong(bBeforeA) - Long.parseLong(aBeforeB);
            if (cmp == 0) {
                return 0;
            }
            if (cmp > 0) {
                return 1;
            }
            return -1;
        }).map(String::valueOf).collect(Collectors.joining(""));
        return removeTrailingZeros(ans);
    }

    private String removeTrailingZeros(String s) {
        StringBuilder sb = new StringBuilder(s);
        int i = 0;
        while (i < sb.length() - 1 && sb.charAt(i) == '0') {
            i++;
        }
        return sb.substring(i);
    }
}
