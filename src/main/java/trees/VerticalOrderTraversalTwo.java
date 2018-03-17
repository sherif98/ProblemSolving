package trees;

import java.util.*;

public class VerticalOrderTraversalTwo {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> q = new ArrayDeque<>();
        if (A != null) {
            q.add(new Pair(A, 0));
        }
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Pair p = q.poll();
                TreeNode t = p.node;
                if (t.left != null) {
                    q.add(new Pair(t.left, p.margin + 1));
                }
                if (t.right != null) {
                    q.add(new Pair(t.right, p.margin - 1));
                }
                if (map.containsKey(p.margin)) {
                    map.get(p.margin).add(t.val);
                } else {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(t.val);
                    map.put(p.margin, list);
                }
            }
        }
        map.forEach((k, v) -> ret.add(v));
        Collections.reverse(ret);
        return ret;
    }


    class Pair {
        TreeNode node;
        int margin;

        Pair(TreeNode node, int margin) {
            this.node = node;
            this.margin = margin;
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
}
