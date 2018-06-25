package trees;

public class SortedListToBinaryTree {
    public TreeNode sortedListToBST(ListNode head) {
        return solve(head);
    }

    private TreeNode solve(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second;
        ListNode root;
        second = slow.next;
        slow.next = null;
        prev.next = null;
        root = slow;
        TreeNode tree = new TreeNode(root.val);
        tree.left = solve(head);
        tree.right = solve(second);
        return tree;
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

    class ListNode {
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
