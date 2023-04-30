package q101_q200;

public class Q190 {
    public int reverseBits(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int tail = n & 1;
            res = (res << 1) | tail;
            n >>>= 1;
        }
        return res;
    }
}
