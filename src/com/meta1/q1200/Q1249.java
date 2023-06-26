package com.meta1.q1200;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Q1249 {
    public String minRemoveToMakeValid(String s) {
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == ')') right++;
        }
        int left = 0;
        StringBuilder builder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
                if (right > 0) {
                    builder.append(c);
                    right--;
                }
            } else if (c == ')') {
                if (left > 0) {
                    builder.append(c);
                    left--;
                } else {
                    right--;
                }
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }

    public String minRemoveToMakeValid1(String s) {
        Set<Integer> validIndex = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') stack.add(i);
            else if (c == ')') {
                if (!stack.isEmpty()) {
                    validIndex.add(i);
                    validIndex.add(stack.pop());
                }
            } else {
                validIndex.add(i);
            }
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (validIndex.contains(i)) {
                builder.append(s.charAt(i));
            }
        }
        return builder.toString();
    }
}
