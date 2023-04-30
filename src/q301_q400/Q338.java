package q301_q400;

public class Q338 {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        if (n == 0) return res;
        res[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) res[i] = res[i >> 1];
            else res[i] = res[i - 1] + 1;
        }
        return res;
    }
}
