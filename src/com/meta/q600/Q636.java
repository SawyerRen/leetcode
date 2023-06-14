package com.meta.q600;

import java.util.List;
import java.util.Stack;

public class Q636 {
    public int[] exclusiveTime(int n, List<String> logs) {
        Stack<Log> stack = new Stack<>();
        int[] res = new int[n];
        for (String s : logs) {
            Log log = new Log(s);
            if (log.isStart) {
                stack.push(log);
            } else {
                Log pop = stack.pop();
                int time = log.timestamp - pop.timestamp + 1;
                res[log.id] += time;
                if (!stack.isEmpty()) {
                    res[stack.peek().id] -= time;
                }
            }
        }
        return res;
    }

    class Log {
        int id;
        boolean isStart;
        int timestamp;

        public Log(String s) {
            String[] split = s.split(":");
            id = Integer.parseInt(split[0]);
            isStart = split[1].equals("start");
            timestamp = Integer.parseInt(split[2]);
        }
    }
}
