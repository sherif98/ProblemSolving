package sets.trie;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HotelReviewsOne {

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Set<String> set = new HashSet<>();
        for (String a : A.split("_")) {
            set.add(a);
        }
        List<Tuple> ret = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            String a = B.get(i);
            int good = 0;
            for (String x : a.split("_")) {
                if (set.contains(x)) {
                    good++;
                }
            }
            ret.add(new Tuple(a, good, i));
        }
        ret.sort(Comparator.comparing(Tuple::getGoodness).reversed().thenComparing(Tuple::getIdx));
        return ret.stream().map(Tuple::getIdx).collect(Collectors.toCollection(ArrayList::new));
    }

    class Tuple {
        String review;
        int goodness;
        int idx;

        Tuple(String review, int goodness, int idx) {
            this.review = review;
            this.goodness = goodness;
            this.idx = idx;
        }

        public int getGoodness() {
            return goodness;
        }

        public int getIdx() {
            return idx;
        }

    }
}
