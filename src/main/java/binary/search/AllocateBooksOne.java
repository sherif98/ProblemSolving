package binary.search;

import java.util.ArrayList;
import java.util.Arrays;

public class AllocateBooksOne {

    public static void main(String[] args) {
        AllocateBooksOne allocateBooks = new AllocateBooksOne();
        int books = allocateBooks.books
                (new ArrayList<>(Arrays.asList(3, 32, 32, 41, 54, 77, 17)), 4);
        System.out.println(books);
    }

    public int books(ArrayList<Integer> nums, int m) {
        if (m > nums.size()) {
            return -1;
        }
        int lastAns = -1;
        int maxRead = Integer.MAX_VALUE;
        while (true) {
            int[] students = new int[m];
            int j = 0;
            int current = 0;
            for (int i = nums.size() - m; i < nums.size(); i++) {
                students[j++] = nums.get(i);
            }
            j = 0;
            for (int i = 0; i <= Math.min(nums.size() - m + j, nums.size() - 1); i++) {
                current += nums.get(i);
                if (current > maxRead) {
                    if (j >= m) {
                        return lastAns;
                    }
                    current -= nums.get(i);
                    students[j++] = current;
                    current = 0;
                    i--;
                }
            }
            if (j >= m) {
                return lastAns;
            }
            if (current <= maxRead) {
                students[j] = current;
                int max = Integer.MIN_VALUE;
                for (int n : students) {
                    max = Math.max(max, n);
                }
                if (lastAns == max) {
                    return lastAns;
                }
                lastAns = max;
                maxRead = max - 1;
            }
        }
    }
}
