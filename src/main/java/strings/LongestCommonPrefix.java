package strings;

import java.util.ArrayList;

public class LongestCommonPrefix {

    public String longestCommonPrefix(ArrayList<String> a) {
        if (a.size() == 0) {
            return "";
        }
        StringBuilder prefix = new StringBuilder();
        int idx = 0;
        while (true) {
            if (idx >= a.get(0).length()) {
                return prefix.toString();
            }
            char first = a.get(0).charAt(idx);
            boolean allMatch = true;
            for (String s : a) {
                if (idx >= s.length() || s.charAt(idx) != first) {
                    allMatch = false;
                }
            }
            if (allMatch) {
                prefix.append(first);
                idx++;
            } else {
                return prefix.toString();
            }
        }
    }
}
