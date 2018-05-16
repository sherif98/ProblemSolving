package linkedlists;

public class RemoveDuplicatesOne {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head.next;
        while (cur != null) {
            while (cur != null && prev.val == cur.val) {
                cur = cur.next;
            }
            prev.next = cur;
            prev = cur;
            if (cur != null) {
                cur = cur.next;
            }
        }
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
