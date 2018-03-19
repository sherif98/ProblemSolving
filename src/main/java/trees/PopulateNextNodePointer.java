package trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulateNextNodePointer {

    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> q = new ArrayDeque<>();
        if (root != null) {
            q.add(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode prev = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = q.poll();
                if (prev != null) {
                    prev.next = cur;
                }
                prev = cur;
                if (i == size - 1) {
                    cur.next = null;
                }
                if (cur.left != null) {
                    q.add(cur.left);
                }
                if (cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;

        TreeLinkNode(int x) {
            val = x;
        }
    }
}
