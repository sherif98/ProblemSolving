package stacks.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack = new ArrayDeque<>();
    private Deque<Integer> min = new ArrayDeque<>();

    public void push(int x) {
        stack.push(x);
        if (min.isEmpty() || x < min.peek()) {
            min.push(x);
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        }
        int num = stack.pop();
        if (num == min.peek()) {
            min.pop();
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        }
        return stack.peek();
    }

    public int getMin() {
        if (min.isEmpty()) {
            return -1;
        }
        return min.peek();
    }
}
