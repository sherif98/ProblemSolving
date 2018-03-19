package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class ZigZagTraversal {

    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode A) {
        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
        Queue<TreeNode> q = new ArrayDeque<>();
        if(A != null) {
            q.add(A);
        }
        boolean rev = false;
        while(!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> cur = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode root = q.poll();
                cur.add(root.val);
                if(root.left != null) {
                    q.add(root.left);
                }
                if(root.right != null) {
                    q.add(root.right);
                }
            }
            if(rev) {
                Collections.reverse(cur);
            }
            rev = !rev;
            ret.add(cur);
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
