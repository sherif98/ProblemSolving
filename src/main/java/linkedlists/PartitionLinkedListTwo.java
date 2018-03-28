package linkedlists;

public class PartitionLinkedListTwo {

    public ListNode partition(ListNode head, int x) {
        if (head.next == null) {
            return head;
        }
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        head1.next = head;
        ListNode prev = head1;
        ListNode current = head;
        ListNode c2 = head2;
        while (current != null) {
            if (current.val >= x) {
                ListNode nxt = current.next;
                current.next = null;
                c2.next = current;
                c2 = current;
                current = nxt;
                prev.next = current;
            } else {
                prev = current;
                current = current.next;
            }
        }
        prev.next = head2.next;
        return head1.next;
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
