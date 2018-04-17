package trees;

import java.util.ArrayList;

public class BinaryTreeFromInorderPreorder {

    private int preIdx;

    public TreeNode buildTree(ArrayList<Integer> preorder, ArrayList<Integer> inorder) {
        return solve(preorder, inorder, 0, inorder.size() - 1);
    }

    private TreeNode solve(ArrayList<Integer> preorder, ArrayList<Integer> inorder,
                           int start, int end) {

        if (start > end) {
            return null;
        }

        int rootVal = preorder.get(preIdx++);
        int idx = -1;
        for (int i = start; i <= end; i++) {
            if (rootVal == inorder.get(i)) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(preorder, inorder, start, idx - 1);
        root.right = solve(preorder, inorder, idx + 1, end);
        return root;
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
