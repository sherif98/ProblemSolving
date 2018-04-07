package stacks.queues;

import java.util.*;

public class SlidingWindowMaximum {

    public static void main(String[] args) {
        SlidingWindowMaximum slidingWindowMaximum = new SlidingWindowMaximum();
        ArrayList<Integer> integers = slidingWindowMaximum.slidingMaximum(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1), 1);
        System.out.println(integers);
    }

    public ArrayList<Integer> slidingMaximum(final List<Integer> nums, int w) {
        Deque<Integer> dq = new ArrayDeque<>();
        ArrayList<Integer> ret = new ArrayList<>();
        for (int i = 0; i < w; i++) {
            while (!dq.isEmpty() && nums.get(i) >= nums.get(dq.peekLast())) {
                dq.pollLast();
            }
            dq.add(i);
        }
        for (int i = w; i < nums.size(); i++) {
            ret.add(nums.get(dq.peekFirst()));
            while (!dq.isEmpty() && nums.get(i) >= nums.get(dq.peekLast())) {
                dq.pollLast();
            }
            dq.add(i);
            while (!dq.isEmpty() && dq.peekFirst() <= i - w) {
                dq.pollFirst();
            }
        }
        ret.add(nums.get(dq.peekFirst()));
        return ret;
    }
}
