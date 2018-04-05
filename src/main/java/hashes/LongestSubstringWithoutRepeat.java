package hashes;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeat {

    public static void main(String[] args) {
        LongestSubstringWithoutRepeat longestSubstringWithoutRepeat = new LongestSubstringWithoutRepeat();
        int bbbbbb = longestSubstringWithoutRepeat.lengthOfLongestSubstring("dadbc");
        System.out.println(bbbbbb);
    }

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int lo = 0;
        int hi = 0;
        int length = 1;
        for (; hi < s.length(); hi++) {
            char c = s.charAt(hi);
            if (set.contains(c)) {
                length = Math.max(length, hi - lo);
                while (lo < hi && s.charAt(lo) != c) {
                    set.remove(s.charAt(lo++));
                }
                lo++;
            } else {
                set.add(c);
            }
        }
        return Math.max(length, hi - lo);
    }
}
