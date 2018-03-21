package linkedlists;

public class isPalindromeTwo {

    public int lPalin(ListNode A) {
        int length = length(A);
        ListNode currentF = A;
        ListNode currentS = A;
        for (int i = 0; i < length / 2; i++) {
            currentF = currentF.next;
        }
        currentF = reverse(currentF);
        for (int i = 0; i < length / 2; i++) {
            if (currentS.val != currentF.val) {
                return 0;
            }
            currentS = currentS.next;
            currentF = currentF.next;
        }
        return 1;
    }

    private ListNode reverse(ListNode head) {
        ListNode current = head;
        ListNode prev = null;
        while (current != null) {
            ListNode nxt = current.next;
            current.next = prev;
            prev = current;
            current = nxt;
        }
        return prev;
    }

    private int length(ListNode head) {
        int length = 0;
        ListNode current = head;
        while (current != null) {
            current = current.next;
            length++;
        }
        return length;
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
