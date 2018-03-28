package linkedlists;

import java.util.ArrayDeque;
import java.util.Deque;

public class PartitionListOne {

    public ListNode partition(ListNode head, int x) {
        if (head.next == null) {
            return head;
        }
        ListNode current = head;
        Deque<ListNode> q = new ArrayDeque<>();
        ListNode prev = null;
        ListNode ret = null;
        while (current != null) {
            if (current.val >= x) {
                if (prev == null) {
                    q.add(current);
                    current = current.next;
                } else {
                    q.add(current);
                    prev.next = current.next;
                    current = current.next;
                }
            } else {
                if (ret == null) {
                    ret = current;
                }
                prev = current;
                current = current.next;
            }
        }
        ListNode merge = null;
        ListNode newHead = null;
        while (!q.isEmpty()) {
            ListNode n = q.poll();
            if (newHead == null) {
                newHead = n;
                merge = n;
                continue;
            }
            merge.next = n;
            merge = n;
        }
        merge.next = null;
        if (prev == null) {
            return newHead;
        }
        prev.next = newHead;
        return ret;
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
