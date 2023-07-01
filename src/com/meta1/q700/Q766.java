package com.meta1.q700;

public class Q766 {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if (matrix[i][j] != matrix[i - 1][j - 1]) return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int left = 2;
        int right = Integer.MAX_VALUE - 1;
        System.out.println((left + right) / 2);
        System.out.println((left + right) >>> 1);
//        int mid = (left + right) / 2;
        System.out.println(left + (right - left) / 2);
    }
}
