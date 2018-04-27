package greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class DistributeCandyOne {

    public int candy(ArrayList<Integer> nums) {
        Queue<Node> pq = new PriorityQueue<>((a, b) -> a.num - b.num);
        for(int i = 0; i < nums.size(); i++) {
            Node n = new Node(nums.get(i), i);
            pq.add(n);
        }
        int ans = 0;
        int[] candy = new int[nums.size()];
        while(!pq.isEmpty()) {
            Node n = pq.poll();
            int i = n.idx;
            int prevCandy = 0;
            int nextCandy = 0;
            int prev = Integer.MIN_VALUE;
            int next = Integer.MIN_VALUE;
            if(i > 0) {
                prevCandy = candy[i - 1];
                prev = nums.get(i - 1);
            }
            if(i < nums.size() - 1) {
                nextCandy = candy[i + 1];
                next = nums.get(i + 1);
            }
            int whatToGive = 1;
            if(n.num > prev) {
                whatToGive = prevCandy + 1;
            }
            if(n.num > next) {
                whatToGive = Math.max(whatToGive, nextCandy + 1);
            }
            candy[i] = whatToGive;
            ans += whatToGive;
        }
        return ans;
    }

    class Node {
        int num;
        int idx;
        Node(int num, int idx) {
            this.num = num;
            this.idx = idx;
        }
    }
}
