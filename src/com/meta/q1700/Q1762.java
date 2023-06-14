package com.meta.q1700;

import java.util.LinkedList;

public class Q1762 {
    public int[] findBuildings(int[] heights) {
        LinkedList<Integer> list = new LinkedList<>();
        int maxHeight = heights[heights.length - 1];
        list.addFirst(heights.length - 1);
        for (int i = heights.length - 2; i >= 0; i--) {
            if (heights[i] > maxHeight) {
                list.addFirst(i);
                maxHeight = heights[i];
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.removeFirst();
        }
        return res;
    }
}
