package com.meta1.q1200;

public class Q1216 {
    public boolean isValidPalindrome(String s, int k) {
        int n = s.length();
        int[][] memo = new int[n][n];
        int remove = helper(memo, s, 0, s.length() - 1);
        return remove <= k;
    }

    private int helper(int[][] memo, String s, int i, int j) {
        if (i >= j) return 0;
        if (memo[i][j] != 0) return memo[i][j];
        int res = Integer.MAX_VALUE;
        if (s.charAt(i) == s.charAt(j)) {
            res = helper(memo, s, i + 1, j - 1);
        } else {
            res = Math.min(helper(memo, s, i, j - 1), helper(memo, s, i + 1, j)) + 1;
        }
        memo[i][j] = res;
        return res;
    }
}
