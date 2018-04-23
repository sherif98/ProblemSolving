package maths;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AllFactors {

    public static void main(String[] args) {
        AllFactors allFactors = new AllFactors();
        ArrayList<Integer> integers = allFactors.allFactors(38808);
        System.out.println(integers);
    }

    public ArrayList<Integer> allFactors(int n) {
        List<Integer> smaller = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();
        double root = Math.sqrt(n);
        for (int i = 1; i <= root; i++) {
            if (n % i == 0) {
                smaller.add(i);
                if (i != root) {
                    greater.add(n / i);
                }
            }
        }
        Collections.reverse(greater);
        return Stream.concat(smaller.stream(), greater.stream())
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
