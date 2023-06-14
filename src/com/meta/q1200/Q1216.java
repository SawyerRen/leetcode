package com.meta.q1200;

public class Q1216 {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] memo = new int[n][n];
        int min = helper(memo, s, 0, s.length() - 1);
        return min <= k;
    }

    private int helper(int[][] memo, String s, int left, int right) {
        if (left >= right) return 0;
        if (memo[left][right] != 0) return memo[left][right];
        int res;
        if (s.charAt(left) == s.charAt(right)) {
            res = helper(memo, s, left + 1, right - 1);
        } else {
            res = Math.min(helper(memo, s, left + 1, right), helper(memo, s, left, right - 1)) + 1;
        }
        memo[left][right] = res;
        return res;
    }
}
