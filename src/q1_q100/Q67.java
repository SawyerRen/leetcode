package q1_q100;

import java.util.Stack;

public class Q67 {
    public String addBinary(String a, String b) {
        Stack<Integer> stack = new Stack<>();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0) {
            int v1 = i >= 0 ? a.charAt(i) - '0' : 0;
            int v2 = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = v1 + v2 + carry;
            stack.push(sum % 2);
            carry = sum / 2;
            i--;
            j--;
        }
        StringBuilder builder = new StringBuilder();
        if (stack.isEmpty() || stack.peek() == 0) return "0";
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
