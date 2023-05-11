package q1_q100;

public class Q53 {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int res = nums[0];
        int cur = nums[0];
        for (int i = 1; i < n; i++) {
            cur = cur < 0 ? nums[i] : nums[i] + cur;
            res = Math.max(res, cur);
        }
        return res;
    }

    public int maxSubArray1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int res = nums[0];
        dp[0] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i] = dp[i - 1] > 0 ? dp[i - 1] + nums[i] : nums[i];
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
