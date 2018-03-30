package linkedlists;

public class RemoveNthNodeFromEnd {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        int cnt = 0;
        ListNode fast = head;
        while (cnt < n && fast != null) {
            fast = fast.next;
            cnt++;
        }
        if (fast == null) {
            return head.next;
        }
        ListNode prev = null;
        ListNode slow = head;
        while (fast != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next;
        }
        prev.next = slow.next;
        return head;
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
