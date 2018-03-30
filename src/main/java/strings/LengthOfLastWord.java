package strings;

public class LengthOfLastWord {

    public int lengthOfLastWord(final String s) {
        String[] splits = s.split(" ");
        if (splits.length == 0) {
            return 0;
        }
        return splits[splits.length - 1].length();
    }
}
