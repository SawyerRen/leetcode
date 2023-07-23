package q0;

public class Q7 {
    public int reverse(int x) {
        long num = x;
        long res = 0;
        while (num != 0) {
            long tail = num % 10;
            res = res * 10 + tail;
            if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) return 0;
            num /= 10;
        }
        return (int) res;
    }
}
