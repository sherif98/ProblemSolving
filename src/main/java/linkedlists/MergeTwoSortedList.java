package linkedlists;

public class MergeTwoSortedList {

    public ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode ret = new ListNode(-1);
        ListNode cur = ret;
        while (first != null && second != null) {
            if (first.val < second.val) {
                cur.next = first;
                first = first.next;
            } else {
                cur.next = second;
                second = second.next;
            }
            cur = cur.next;
        }
        if (first == null) {
            cur.next = second;
        }
        if (second == null) {
            cur.next = first;
        }
        return ret.next;
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
