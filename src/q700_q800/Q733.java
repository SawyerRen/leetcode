package q700_q800;

public class Q733 {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) return image;
        helper(image, sr, sc, color, image[sr][sc]);
        return image;
    }

    int[][] dirs = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void helper(int[][] image, int i, int j, int color, int oldColor) {
        if (i < 0 || i >= image.length || j < 0 || j >= image[0].length || image[i][j] != oldColor) return;
        image[i][j] = color;
        for (int[] dir : dirs) {
            helper(image, i + dir[0], j + dir[1], color, oldColor);
        }
    }
}
