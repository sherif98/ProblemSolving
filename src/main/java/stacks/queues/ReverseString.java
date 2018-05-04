package stacks.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseString {

    public String reverseString(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for(char c : s.toCharArray()) {
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder(s.length());
        while(!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
