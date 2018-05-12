package bits;

public class NumberOfOneBits {

    public int numSetBits(long n) {
        int cnt = 0;
        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                cnt++;
            }
        }
        return cnt;
    }
}
