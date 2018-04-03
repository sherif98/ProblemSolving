package hashes;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class WindowString {


    public static void main(String[] args) {
        WindowString windowString = new WindowString();
        String string = windowString.minWindow("adobedodebanc", "abc");
        System.out.println(string);
    }


    public String minWindow(String s, String t) {
//        Map<Character, Integer> needed = new HashMap<>();
//        for (char c : t.toCharArray()) {
//            needed.merge(c, 1, Integer::sum);
//        }
        Map<Character, Long> needed = t.chars()
                .mapToObj(n -> (char) n)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<Character, Integer> have = new HashMap<>();
        int lo = 0;
        int hi = 0;
        int start = -1;
        int min = Integer.MAX_VALUE;
        while (hi < s.length()) {
            char c = s.charAt(hi);
            if (needed.containsKey(c)) {
                have.merge(c, 1, Integer::sum);
            }
            if (haveEnoughCharacter(needed, have)) {
                while (lo < hi) {
                    char ch = s.charAt(lo);
                    if (needed.containsKey(ch)) {
                        if (have.get(ch) > needed.get(ch)) {
                            have.merge(ch, -1, Integer::sum);
                        } else {
                            break;
                        }
                    }
                    lo++;
                }
                if (start == -1 || min > hi - lo + 1) {
                    start = lo;
                    min = hi - lo + 1;
                }
            }
            hi++;
        }
        if (start == -1) {
            return "";
        }
        return s.substring(start, start + min);
    }

    private boolean haveEnoughCharacter(Map<Character, Long> needed, Map<Character, Integer> have) {
        boolean ret = true;
        for (Map.Entry<Character, Long> entry : needed.entrySet()) {
            if (!have.containsKey(entry.getKey())) {
                return false;
            }
            ret = ret && have.get(entry.getKey()) >= entry.getValue();
        }
        return ret;
    }


}
