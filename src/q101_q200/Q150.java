package q101_q200;

import java.util.Stack;

public class Q150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                    int pop1 = stack.pop();
                    int pop2 = stack.pop();
                    stack.push(pop2 - pop1);
                    break;
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                    int pop3 = stack.pop();
                    int pop4 = stack.pop();
                    stack.push(pop4 / pop3);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
                    break;
            }
        }
        return stack.pop();
    }
}
