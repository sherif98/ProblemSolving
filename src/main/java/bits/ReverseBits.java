package bits;

public class ReverseBits {


    public static void main(String[] args) {
        ReverseBits reverseBits = new ReverseBits();
        long reverse = reverseBits.reverse(3L);
        System.out.println(reverse);
    }


    public long reverse(long n) {
        long ans = 0;
        for (long i = 0; i < 32; i++) {
            if ((n & (1 << i)) != 0) {
                long x = 31 - i;
                long z = (long) 1 << x;
                ans |= z;
            }
        }
        return ans;
    }
}
