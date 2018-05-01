package strings;

public class AddBinary {

    public static void main(String[] args) {
        AddBinary addBinary = new AddBinary();
        String s = addBinary.addBinary("111", "11");
        System.out.println(s);
    }

    public String addBinary(String a, String b) {
        StringBuilder first = new StringBuilder(a);
        StringBuilder second = new StringBuilder(b);
        if (first.length() < second.length()) {
            int diff = second.length() - first.length();
            for (int i = 0; i < diff; i++) {
                first.insert(0, '0');
            }
        }
        if (second.length() < first.length()) {
            int diff = first.length() - second.length();
            for (int i = 0; i < diff; i++) {
                second.insert(0, '0');
            }
        }
        StringBuilder ans = new StringBuilder();
        char carry = '0';
        for (int i = first.length() - 1; i >= 0; i--) {
            char f = first.charAt(i);
            char s = second.charAt(i);
            if (s == '1' && f == '1') {
                if (carry == '1') {
                    ans.append('1');
                } else {
                    ans.append('0');
                }
                carry = '1';
            } else if ((s == '1' && f == '0') || (s == '0' && f == '1')) {
                if (carry == '1') {
                    ans.append('0');
                } else {
                    ans.append('1');
                }
            } else {
                if (carry == '1') {
                    carry = '0';
                    ans.append('1');
                } else {
                    ans.append('0');
                }
            }
        }
        if (carry == '1') {
            ans.append('1');
        }

        return ans.reverse().toString();
    }
}
