package greedy;

import java.util.ArrayList;
import java.util.Collections;

public class AssignMiceToHoles {

    public int mice(ArrayList<Integer> mice, ArrayList<Integer> holes) {
        Collections.sort(mice);
        Collections.sort(holes);
        int ans = 0;
        for (int i = 0; i < mice.size(); i++) {
            int mouse = mice.get(i);
            int hole = holes.get(i);
            ans = Math.max(ans, Math.abs(mouse - hole));
        }
        return ans;
    }
}
