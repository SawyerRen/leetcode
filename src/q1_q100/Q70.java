package q1_q100;

public class Q70 {
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int pre1 = 1;
        int pre2 = 2;
        for (int i = 3; i < n + 1; i++) {
            int temp = pre1;
            pre1 = pre2;
            pre2 = temp + pre2;
        }
        return pre2;
    }

    public int climbStairs1(int n) {
        if (n == 1 || n == 2) return n;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
