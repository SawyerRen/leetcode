package com.meta.q700;

public class Q791 {
    public String customSortString(String order, String s) {
        int[] orderArr = new int[26];
        for (int i = 0; i < order.length(); i++) {
            orderArr[order.charAt(i) - 'a'] = i + 1;
        }
        StringBuilder[] builders = new StringBuilder[27];
        for (char c : s.toCharArray()) {
            int index = orderArr[c - 'a'];
            if (builders[index] == null) builders[index] = new StringBuilder();
            builders[index].append(c);
        }
        StringBuilder builder = new StringBuilder();
        for (StringBuilder stringBuilder : builders) {
            if (stringBuilder != null) builder.append(stringBuilder);
        }
        return builder.toString();
    }
}
