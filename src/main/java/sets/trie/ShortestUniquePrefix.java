package sets.trie;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ShortestUniquePrefix {

    public ArrayList<String> prefix(ArrayList<String> A) {
        Trie trie = new Trie();
        A.forEach(trie::put);
        return A.stream().map(trie::getPrefix).collect(Collectors.toCollection(ArrayList::new));
    }

    private static class Node {
        int count;
        Node[] next = new Node[26];
    }

    class Trie {


        private Node root = new Node();

        public void put(String k) {
            root = put(root, k, 0);
        }

        private Node put(Node root, String k, int d) {
            if (root == null) {
                root = new Node();
            }
            if (d == k.length()) {
                root.count++;
                return root;
            }
            int idx = k.charAt(d) - 'a';
            root.count++;
            root.next[idx] = put(root.next[idx], k, d + 1);
            return root;
        }

        public String getPrefix(String k) {
            return getPrefix(root, k, "", 0);
        }

        private String getPrefix(Node root, String k, String p, int d) {
            if (root == null) {
                return "";
            }
            if (root.count == 1) {
                return p;
            }
            char c = k.charAt(d);
            return getPrefix(root.next[c - 'a'], k, p + c, d + 1);
        }
    }
}

