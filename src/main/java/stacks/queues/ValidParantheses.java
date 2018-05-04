package stacks.queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class ValidParantheses {

    public int isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                char top = stack.pop();
                if (c == ')' && top != '(') {
                    return 0;
                }
                if (c == ']' && top != '[') {
                    return 0;
                }
                if (c == '}' && top != '{') {
                    return 0;
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
