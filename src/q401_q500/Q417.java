package q401_q500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q417 {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            helper(heights, i, 0, pacific);
            helper(heights, i, n - 1, atlantic);
        }
        for (int j = 0; j < n; j++) {
            helper(heights, 0, j, pacific);
            helper(heights, m - 1, j, atlantic);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) res.add(Arrays.asList(i, j));
            }
        }
        return res;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {0, -1}, {1, 0}};

    private void helper(int[][] heights, int i, int j, boolean[][] reach) {
        reach[i][j] = true;
        for (int[] dir : dirs) {
            int x = i + dir[0], y = j + dir[1];
            if (x >= 0 && x < heights.length && y >= 0 && y < heights[0].length &&
                    heights[x][y] >= heights[i][j] && !reach[x][y]) {
                helper(heights, x, y, reach);
            }
        }
    }
}
