package com.meta1.q0;

public class Q65 {
    public boolean isNumber(String s) {
        s = s.trim().toLowerCase();
        boolean seenDot = false;
        boolean seenE = false;
        boolean numberBeforeE = false;
        boolean numberAfterE = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                if (seenE) numberAfterE = true;
                else numberBeforeE = true;
            } else if (c == 'e') {
                if (seenE) return false;
                seenE = true;
            } else if (c == '.') {
                if (seenE || seenDot) return false;
                seenDot = true;
            } else if (c == '+' || c == '-') {
                if (i > 0 && s.charAt(i - 1) != 'e') return false;
            } else {
                return false;
            }
        }
        if (seenE) return numberBeforeE && numberAfterE;
        return numberBeforeE;
    }
}
