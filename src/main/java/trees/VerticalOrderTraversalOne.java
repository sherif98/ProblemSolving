package trees;

import java.util.*;
import java.util.stream.Collectors;

public class VerticalOrderTraversalOne {
    public ArrayList<ArrayList<Integer>> verticalOrderTraversal(TreeNode A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        TreeMap<Integer, ArrayList<Pair>> map = new TreeMap<>();
        solve(A, map, 0, 0);
        map.forEach((key, value) -> {
            ArrayList<Integer> list = value.stream()
                    .sorted(Comparator.comparingInt(a -> a.depth))
                    .map(n -> n.val).collect(Collectors.toCollection(ArrayList::new));
            ret.add(list);
        });
        Collections.reverse(ret);
        return ret;
    }

    private void solve(TreeNode root, TreeMap<Integer, ArrayList<Pair>> map, int margin,
                       int depth) {
        if (root == null) {
            return;
        }
        if (map.containsKey(margin)) {
            map.get(margin).add(new Pair(root.val, depth));
        } else {
            ArrayList<Pair> list = new ArrayList<>();
            list.add(new Pair(root.val, depth));
            map.put(margin, list);
        }
        solve(root.left, map, margin + 1, depth + 1);
        solve(root.right, map, margin - 1, depth + 1);
    }

    class Pair {
        int val;
        int depth;

        Pair(int val, int depth) {
            this.val = val;
            this.depth = depth;
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