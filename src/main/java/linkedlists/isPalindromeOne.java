package linkedlists;

import java.util.ArrayDeque;
import java.util.Deque;

public class isPalindromeOne {

    public int lPalin(ListNode A) {
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode current = A;
        while (current != null) {
            stack.push(current);
            current = current.next;
        }
        int length = stack.size() / 2;
        ListNode first = A;
        for (int i = 0; i < length; i++) {
            if (first.val != stack.pop().val) {
                return 0;
            }
            first = first.next;
        }
        return 1;

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
