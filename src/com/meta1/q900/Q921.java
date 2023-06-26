package com.meta1.q900;

import java.util.Stack;

public class Q921 {
    public int minAddToMakeValid(String s) {
        int left = 0, right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') left++;
            else {
                if (left > 0) left--;
                else right++;
            }
        }
        return left + right;
    }

    public int minAddToMakeValid1(String s) {
        Stack<Character> stack = new Stack<>();
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') stack.push(c);
            else {
                if (!stack.isEmpty()) stack.pop();
                else right++;
            }
        }
        return stack.size() + right;
    }
}
