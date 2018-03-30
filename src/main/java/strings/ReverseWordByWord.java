package strings;

public class ReverseWordByWord {

    public String reverseWords(String a) {
        String[] splits = a.split(" ");
        int lo = 0;
        int hi = splits.length - 1;
        while (lo < hi) {
            String tmp = splits[lo];
            splits[lo] = splits[hi];
            splits[hi] = tmp;
            lo++;
            hi--;
        }
        return String.join(" ", splits);
    }
}
