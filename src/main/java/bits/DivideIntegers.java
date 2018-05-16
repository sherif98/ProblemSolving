package bits;

public class DivideIntegers {

    public static void main(String[] args) {
        DivideIntegers d = new DivideIntegers();
        int divide = d.divide(10, 3);
        System.out.println(divide);
    }

    public int divide(int a, int b) {
        int sign = 1;
        if (a <= 0 && b <= 0) {
            sign = 1;
        } else if (a < 0 || b < 0) {
            sign = -1;
        }
        long aa = Math.abs((long) a);
        long bb = Math.abs((long) b);
        long temp = 0;
        long ans = 0;
        for (int i = 31; i >= 0; i--) {
            if ((temp + (bb << i)) <= aa) {
                temp += (bb << i);
                ans |= (1L << i);
            }
        }
        long ret =  ans * sign;
        if (ret > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) ans * sign;
    }
}
