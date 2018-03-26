package trees;

import java.util.HashSet;
import java.util.Set;

public class TreeTwoSumOne {

    public int t2Sum(TreeNode A, int B) {
        return solve(A, B, new HashSet<>()) ? 1 : 0;
    }

    private boolean solve(TreeNode root, int target, Set<Integer> set) {
        if (root == null) {
            return false;
        }
        if (set.contains(target - root.val)) {
            return true;
        }
        set.add(root.val);
        return solve(root.left, target, set) || solve(root.right, target, set);
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
