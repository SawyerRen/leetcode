package q301_q400;

import java.util.Stack;

public class Q394 {
    public String decodeString(String s) {
        StringBuilder builder = new StringBuilder();
        int count = 0;
        Stack<Integer> countStack = new Stack<>();
        Stack<StringBuilder> builderStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                count = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    count = count * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
            } else if (c == '[') {
                countStack.push(count);
                builderStack.push(builder);
                builder = new StringBuilder();
                count = 0;
            } else if (c == ']') {
                StringBuilder pre = builderStack.pop();
                int temp = countStack.pop();
                for (int j = 0; j < temp; j++) {
                    pre.append(builder);
                }
                builder = pre;
            } else {
                builder.append(c);
            }
        }
        return builder.toString();
    }
}
