package q700_q800;

import java.util.Stack;

public class Q735 {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int asteroid : asteroids) {
            boolean push = true;
            if (asteroid < 0) {
                while (!stack.isEmpty() && stack.peek() > 0) {
                    Integer pre = stack.peek();
                    if (pre == -asteroid) {
                        stack.pop();
                        push = false;
                        break;
                    } else if (pre > -asteroid) {
                        push = false;
                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            if (push) stack.push(asteroid);
        }
        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
