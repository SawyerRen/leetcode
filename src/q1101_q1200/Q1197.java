package q1101_q1200;

import java.util.*;

public class Q1197 {
    public int minKnightMoves(int x, int y) {
        Map<String, Integer> memo = new HashMap<>();
        return helper(memo, Math.abs(x), Math.abs(y));
    }

    private int helper(Map<String, Integer> memo, int x, int y) {
        if (x == 0 && y == 0) return 0;
        if (x + y == 2) return 2;
        String s = x + "," + y;
        if (memo.containsKey(s)) return memo.get(s);
        int res = Math.min(helper(memo, Math.abs(x - 1), Math.abs(y - 2)), helper(memo, Math.abs(x - 2), Math.abs(y - 1))) + 1;
        memo.put(s, res);
        return res;
    }

    public int minKnightMoves1(int x, int y) {
        x = Math.abs(x);
        y = Math.abs(y);
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        Set<String> visited = new HashSet<>();
        visited.add(x + "," + y);
        int[][] dirs = {{-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}};
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                if (poll[0] == 0 && poll[1] == 0) return res;
                for (int[] dir : dirs) {
                    int r = poll[0] + dir[0], c = poll[1] + dir[1];
                    if (r < -1 || c < -1 || visited.contains(r + "," + c)) continue;
                    queue.add(new int[]{r, c});
                    visited.add(r + "," + c);
                }
            }
            res++;
        }
        return -1;
    }
}
