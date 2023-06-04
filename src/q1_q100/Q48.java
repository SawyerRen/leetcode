package q1_q100;

public class Q48 {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                int t = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = t;
            }
        }
        for (int i = 0; i < n; i++) {
            int[] row = matrix[i];
            int r1 = 0, r2 = n - 1;
            while (r1 < r2) {
                int t = row[r1];
                row[r1] = row[r2];
                row[r2] = t;
                r1++;
                r2--;
            }
        }
    }
}
