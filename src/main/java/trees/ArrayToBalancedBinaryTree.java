package trees;

import java.util.List;

public class ArrayToBalancedBinaryTree {

    public TreeNode sortedArrayToBST(final List<Integer> a) {
        return solve(0, a.size() - 1, a);
    }

    private TreeNode solve(int lo, int hi, List<Integer> nums) {
        if (hi < lo) {
            return null;
        }
        if (lo == hi) {
            return new TreeNode(nums.get(lo));
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(nums.get(mid));
        node.left = solve(lo, mid - 1, nums);
        node.right = solve(mid + 1, hi, nums);
        return node;
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
