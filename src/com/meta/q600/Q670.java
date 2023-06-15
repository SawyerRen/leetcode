package com.meta.q600;

public class Q670 {
    public int maximumSwap(int num) {
        int[] index = new int[10];
        String n = String.valueOf(num);
        for (int i = 0; i < n.length(); i++) {
            index[n.charAt(i) - '0'] = i;
        }
        for (int i = 0; i < n.length(); i++) {
            int cur = n.charAt(i) - '0';
            for (int j = 9; j > cur; j--) {
                if (index[j] > i) {
                    char[] chars = n.toCharArray();
                    char c = chars[i];
                    chars[i] = chars[index[j]];
                    chars[index[j]] = c;
                    return Integer.parseInt(new String(chars));
                }
            }
        }
        return num;
    }
}
