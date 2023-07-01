package com.meta1.q600;

public class Q670 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int[] lastIndex = new int[10];
        for (int i = 0; i < s.length(); i++) {
            lastIndex[s.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            for (int j = 9; j > c - '0'; j--) {
                if (lastIndex[j] > i) {
                    char[] chars = s.toCharArray();
                    char t = chars[i];
                    chars[i] = chars[lastIndex[j]];
                    chars[lastIndex[j]] = t;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
