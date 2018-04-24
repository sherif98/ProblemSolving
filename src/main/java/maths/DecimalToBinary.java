package maths;

public class DecimalToBinary {

    public String findDigitsInBinary(int n) {
        if (n == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (n != 0) {
            int mod = n % 2;
            sb.append(mod);
            n /= 2;
        }
        return sb.reverse().toString();
    }
}
