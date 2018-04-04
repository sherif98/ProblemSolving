package hashes;

import java.util.HashMap;
import java.util.Map;

public class CopyList {

    public RandomListNode copyRandomList(RandomListNode head) {
        RandomListNode newHead = new RandomListNode(-1);
        RandomListNode current = head;
        RandomListNode newCurrent = newHead;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (current != null) {
            RandomListNode n = new RandomListNode(current.label);
            newCurrent.next = n;
            map.put(current, n);
            current = current.next;
            newCurrent = newCurrent.next;
        }

        current = head;
        while (current != null) {
            RandomListNode oldRand = current.random;
            RandomListNode newRand = map.get(oldRand);
            map.get(current).random = newRand;
            current = current.next;
        }
        return newHead.next;
    }

    class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }
}
