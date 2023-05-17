package q401_q500;

public class Q416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        boolean[][] dp = new boolean[nums.length][sum + 1];
        for (int i = 1; i < sum + 1; i++) {
            dp[0][i] = false;
        }
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (j >= nums[i]) {
                    dp[i][j] = dp[i - 1][j - nums[i]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[nums.length - 1][sum];
    }
}
