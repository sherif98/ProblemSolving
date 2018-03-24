package backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LetterPhone {

    public ArrayList<String> letterCombinations(String A) {
        ArrayList<String> ret = new ArrayList<>();
        Map<Character, String> map = new HashMap<>();
        map.put('1', "1");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        map.put('0', "0");
        solve(A, 0, map, "", ret);
        return ret;
    }

    private void solve(String nums, int idx, Map<Character, String> map, String p,
                       ArrayList<String> ret) {
        if (idx == nums.length()) {
            ret.add(p);
            return;
        }
        char number = nums.charAt(idx);
        for (char c : map.get(number).toCharArray()) {
            solve(nums, idx + 1, map, p + c, ret);
        }
    }
}
