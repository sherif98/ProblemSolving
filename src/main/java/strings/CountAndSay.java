package strings;

public class CountAndSay {

    public String countAndSay(int n) {
        String ret = "1";
        for (int i = 1; i < n; i++) {
            ret = getNext(ret);
        }
        return ret;
    }

    private String getNext(String s) {
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char start = s.charAt(i);
            int cnt = 0;
            int j = i;
            for (; j < s.length() && s.charAt(j) == start; j++) {
                cnt++;
            }
            ret.append(cnt).append(start);
            i = j - 1;
        }
        return ret.toString();
    }
}
