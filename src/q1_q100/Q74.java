package q1_q100;

public class Q74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid / n, y = mid % n;
            if (matrix[x][y] == target) return true;
            if (matrix[x][y] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
