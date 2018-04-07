package heaps.maps;

import java.util.*;

public class NMaxPairCombinations {


    public static void main(String[] args) {
        NMaxPairCombinations nMaxPairCombinations = new NMaxPairCombinations();
        ArrayList<Integer> solve = nMaxPairCombinations
                .solve(new ArrayList<>(Arrays.asList(1, 4, 2, 3)), new ArrayList<>(Arrays.asList(2, 5, 1, 6)));
        System.out.println(solve);
    }

    public ArrayList<Integer> solve(ArrayList<Integer> A, ArrayList<Integer> B) {
        A.sort(Collections.reverseOrder());
        B.sort(Collections.reverseOrder());
        Queue<Integer> pq = new PriorityQueue<>();

        for (int a : A) {
            for (int b : B) {
                int sum = a + b;

                if (pq.size() < A.size()) {
                    pq.add(sum);
                } else {
                    if (sum > pq.peek()) {
                        pq.poll();
                        pq.add(sum);
                    } else {
                        break;
                    }
                }
            }
        }
        ArrayList<Integer> ret = new ArrayList<>(pq);
        ret.sort(Collections.reverseOrder());
        return ret;
    }
}
