package stacks.queues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;

public class EvaluateExpression {

    public int evalRPN(ArrayList<String> expr) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String s : expr) {
            switch (s) {
                case "+": {
                    int second = stack.pop();
                    int first = stack.pop();
                    int sum = first + second;
                    stack.push(sum);
                    break;
                }
                case "-": {
                    int second = stack.pop();
                    int first = stack.pop();
                    int sub = first - second;
                    stack.push(sub);
                    break;
                }
                case "/": {
                    int second = stack.pop();
                    int first = stack.pop();
                    int div = first / second;
                    stack.push(div);
                    break;
                }
                case "*": {
                    int second = stack.pop();
                    int first = stack.pop();
                    int mul = first * second;
                    stack.push(mul);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(s));
                    break;
            }
        }
        return stack.pop();
    }
}
