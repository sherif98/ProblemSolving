package trees;

import java.util.ArrayList;

public class BinaryTreeFromInorderPostorder {
    private int postIdx;

    public TreeNode buildTree(ArrayList<Integer> inorder, ArrayList<Integer> postorder) {
        postIdx = postorder.size() - 1;
        return solve(inorder, postorder, 0, inorder.size() - 1);

    }

    private TreeNode solve(ArrayList<Integer> inorder, ArrayList<Integer> postorder,
                           int start, int end) {

        if (start > end) {
            return null;
        }

        int rootVal = postorder.get(postIdx--);
        int idx = -1;
        for (int i = start; i <= end; i++) {
            if (inorder.get(i) == rootVal) {
                idx = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootVal);
        root.right = solve(inorder, postorder, idx + 1, end);
        root.left = solve(inorder, postorder, start, idx - 1);
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
