package com.meta.q400;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int index = 0;
        for (int i = 0; i < abbr.length(); i++) {
            if (index >= word.length()) return false;
            char c = abbr.charAt(i);
            if (!Character.isDigit(c)) {
                if (c != word.charAt(index)) return false;
                index++;
            } else {
                if (c == '0') return false;
                int count = c - '0';
                while (i + 1 < abbr.length() && Character.isDigit(abbr.charAt(i + 1))) {
                    count = count * 10 + abbr.charAt(i + 1) - '0';
                    i++;
                }
                index += count;
            }
        }
        return index == word.length();
    }
}
