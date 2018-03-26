package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

public class RecoverBST {

    public ArrayList<Integer> recoverTree(TreeNode A) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode cur = A;
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            cur = stack.pop();
            if (prev != null) {
                if (prev.val > cur.val) {
                    if (ret.size() != 0) {
                        ArrayList<Integer> x = new ArrayList<>(Arrays.asList(ret.get(1), cur.val));
                        x.sort(Integer::compareTo);
                        return x;
                    }
                    ret.add(cur.val);
                    ret.add(prev.val);
                }
            }
            TreeNode tmp = cur;
            if (cur.right != null) {
                cur = cur.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
            prev = tmp;
        }
        return ret;
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
