package q0;

import java.util.Arrays;

public class Q5 {
    int left = 0, right = 0, maxLen = 0;

    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            helper(s, i, i);
            helper(s, i, i + 1);
        }
        return s.substring(left, right);
    }

    private void helper(String s, int i, int j) {
        while (i >=0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        int len = j - i - 1;
        if (len > maxLen) {
            maxLen = len;
            left = i + 1;
            right = j;
        }
    }
}
