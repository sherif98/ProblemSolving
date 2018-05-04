package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrderMatrix {

    public static void main(String[] args) {
        ArrayList<Integer> one = new ArrayList<>(Arrays.asList(1, 2));
//        ArrayList<Integer> two = new ArrayList<>(Arrays.asList(2));
//        ArrayList<Integer> three = new ArrayList<>(Arrays.asList(3));
//        ArrayList<Integer> four = new ArrayList<>(Arrays.asList(10, 11, 12));
        SpiralOrderMatrix orderMatrix = new SpiralOrderMatrix();
        ArrayList<Integer> integers = orderMatrix.spiralOrder(Arrays.asList(one));
        System.out.println(integers);
    }

    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> matrix) {
        int right = matrix.get(0).size();
        int down = matrix.size();
        int up = 0;
        int left = 0;
        ArrayList<Integer> ans = new ArrayList<>();
        while (ans.size() < matrix.get(0).size() * matrix.size()) {
            for (int i = left; i < right; i++) {
                ans.add(matrix.get(up).get(i));
            }
            up++;
            right--;
            boolean addedDown = false;
            for (int i = up; i < down; i++) {
                addedDown = true;
                ans.add(matrix.get(i).get(right));
            }
            boolean addedLeft = false;
            if (addedDown) {
                for (int i = right - 1; i >= left; i--) {
                    addedLeft = true;
                    ans.add(matrix.get(down - 1).get(i));
                }
            }
            down--;
            if (addedLeft) {
                for (int i = down - 1; i >= up; i--) {
                    ans.add(matrix.get(i).get(left));
                }
            }
            left++;
        }
        return ans;
    }
}
