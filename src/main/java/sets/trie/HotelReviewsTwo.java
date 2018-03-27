package sets.trie;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class HotelReviewsTwo {

    public ArrayList<Integer> solve(String A, ArrayList<String> B) {
        Trie trie = new Trie();
        for (String a : A.split("_")) {
            trie.put(a);
        }
        List<Tuple> ret = new ArrayList<>();
        for (int i = 0; i < B.size(); i++) {
            String a = B.get(i);
            int good = 0;
            for (String x : a.split("_")) {
                if (trie.contains(x)) {
                    good++;
                }
            }
            ret.add(new Tuple(a, good, i));
        }
        ret.sort(Comparator.comparing(Tuple::getGoodness).reversed().thenComparing(Tuple::getIdx));
        return ret.stream().map(Tuple::getIdx).collect(Collectors.toCollection(ArrayList::new));
    }
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

class Trie {

    private static class Node {
        private boolean end;
        private Node[] next = new Node[26];
    }

    private Node root = new Node();

    public void put(String k) {
        root = put(root, k, 0);
    }

    private Node put(Node root, String k, int d) {
        if (root == null) {
            root = new Node();
        }
        if (d == k.length()) {
            root.end = true;
            return root;
        }
        int idx = k.charAt(d) - 'a';
        root.next[idx] = put(root.next[idx], k, d + 1);
        return root;
    }

    public boolean contains(String k) {
        return contains(root, k, 0);
    }

    private boolean contains(Node root, String k, int d) {
        if (root == null) {
            return false;
        }
        if (d == k.length()) {
            return root.end;
        }
        int idx = k.charAt(d) - 'a';
        return contains(root.next[idx], k, d + 1);
    }
}
