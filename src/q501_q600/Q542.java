package q501_q600;

import java.util.LinkedList;
import java.util.Queue;

public class Q542 {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
        int dist = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] poll = queue.poll();
                mat[poll[0]][poll[1]] = dist;
                for (int[] dir : dirs) {
                    int x = poll[0] + dir[0], y = poll[1] + dir[1];
                    if (x < 0 || x >= m || y < 0 || y >= n || visited[x][y]) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            dist++;
        }
        return mat;
    }
}
