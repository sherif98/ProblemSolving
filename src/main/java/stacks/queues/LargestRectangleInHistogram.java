package stacks.queues;

import java.util.*;

public class LargestRectangleInHistogram {


    public int largestRectangleArea(ArrayList<Integer> nums) {
        List<Integer> beforeMe = getNumberLessAndBefore(nums);
        Collections.reverse(nums);
        List<Integer> afterMe = getNumberLessAndBefore(nums);
        Collections.reverse(nums);
        Collections.reverse(afterMe);
        int ret = Integer.MIN_VALUE;
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            ret = Math.max(ret, n * (beforeMe.get(i) + afterMe.get(i) + 1));
        }
        return ret;
    }

    private List<Integer> getNumberLessAndBefore(ArrayList<Integer> nums) {
        Deque<Pair> stack = new ArrayDeque<>();
        List<Integer> beforeMe = new ArrayList<>();
        for (int i = 0; i < nums.size(); i++) {
            int n = nums.get(i);
            if (stack.isEmpty()) {
                beforeMe.add(0);
                stack.push(new Pair(n, i));
            } else {
                int cnt = 0;
                Pair last;
                while (!stack.isEmpty() && stack.peek().num >= n) {
                    cnt++;
                    last = stack.pop();
                    cnt += beforeMe.get(last.idx);
                }
                beforeMe.add(cnt);
                stack.push(new Pair(n, i));
            }
        }
        return beforeMe;
    }
}

class Pair {
    int num;
    int idx;

    Pair(int num, int idx) {
        this.num = num;
        this.idx = idx;
    }
}
