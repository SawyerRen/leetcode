package q201_q300;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            if (list.isEmpty() || list.get(list.size() - 1) < num) {
                list.add(num);
            } else {
                int index = helper(list, num);
                list.set(index, num);
            }
        }
        return list.size();
    }

    private int helper(List<Integer> list, int num) {
        int left = 0, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) >= num) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public int lengthOfLIS1(int[] nums) {
        int res = 1;
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    res = Math.max(res, dp[i]);
                }
            }
        }
        return res;
    }
}
