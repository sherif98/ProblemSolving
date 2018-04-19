package heaps.maps;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;

public class MagicianAndChocolate {


    public int nchoc(int k, ArrayList<Integer> nums) {
        Queue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(nums);
        long ans = 0;
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            int max = pq.poll();
            ans += max;
            ans %= (1e9 + 7);
            pq.add(max / 2);
        }
        return (int) ans;
    }

}
