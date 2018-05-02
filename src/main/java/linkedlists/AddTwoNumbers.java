package linkedlists;

public class AddTwoNumbers {


    public ListNode addTwoNumbers(ListNode a, ListNode b) {
        int carry = 0;
        ListNode first = a;
        ListNode second = b;
        ListNode ans = new ListNode(-1);
        ListNode ret = ans;
        while (first != null && second != null) {
            int f = first.val;
            int s = second.val;
            int sum = (f + s + carry) % 10;
            carry = (f + s + carry) / 10;
            ans.next = new ListNode(sum);
            ans = ans.next;
            first = first.next;
            second = second.next;
        }
        if (first == null && second != null) {
            if (carry == 0) {
                ans.next = second;
            } else {
                ListNode sum = addTwoNumbers(second, new ListNode(carry));
                ans.next = sum;
            }
        } else if (first != null && second == null) {
            if (carry == 0) {
                ans.next = first;
            } else {
                ListNode sum = addTwoNumbers(first, new ListNode(carry));
                ans.next = sum;
            }
        } else {
            if (carry != 0) {
                ans.next = new ListNode(carry);
            }
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
