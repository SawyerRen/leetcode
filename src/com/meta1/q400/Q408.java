package com.meta1.q400;

public class Q408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            char c1 = abbr.charAt(j);
            if (c1 == '0') return false;
            if (!Character.isDigit(c1)) {
                if (c1 != word.charAt(i)) {
                    return false;
                } else {
                    i++;
                    j++;
                }
            } else {
                int count = c1 - '0';
                while (j + 1 < abbr.length() && Character.isDigit(abbr.charAt(j + 1))) {
                    count = count * 10 + abbr.charAt(j + 1) - '0';
                    j++;
                }
                i += count;
                j++;
            }
        }
        return i == word.length() && j == abbr.length();
    }
}
