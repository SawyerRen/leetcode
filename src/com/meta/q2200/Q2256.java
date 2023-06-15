package com.meta.q2200;

public class Q2256 {
    public int minimumAverageDifference(int[] nums) {
        long total = 0;
        for (int num : nums) {
            total += num;
        }
        int res = -1;
        long minDiff = Integer.MAX_VALUE;
        long preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            long left = preSum / (i + 1);
            long right = total - preSum;
            if (i != nums.length - 1) {
                right /= (nums.length - i - 1);
            }
            long diff = Math.abs(left - right);
            if (diff < minDiff) {
                minDiff = diff;
                res = i;
            }
        }
        return res;
    }
}
