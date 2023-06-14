package com.meta.q0;

import java.util.LinkedList;
import java.util.Stack;

public class Q71 {
    public String simplifyPath(String path) {
        String[] split = path.split("/");
        LinkedList<String> list = new LinkedList<>();
        for (String s : split) {
            if (s.equals("") || s.equals(".")) continue;
            if (s.equals("..")) {
                if (list.size() > 0) list.removeLast();
            } else {
                list.addLast(s);
            }
        }
        if (list.isEmpty()) return "/";
        StringBuilder builder = new StringBuilder();
        while (!list.isEmpty()) {
            builder.append("/").append(list.removeFirst());
        }
        return builder.toString();
    }
}
