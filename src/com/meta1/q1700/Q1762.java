package com.meta1.q1700;

import java.util.LinkedList;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        if (heights.length == 0) return new int[0];
        LinkedList<Integer> list = new LinkedList<>();
        list.addFirst(heights.length - 1);
        int max = heights[heights.length - 1];
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > max) {
                max = heights[i];
                list.addFirst(i);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }
}
