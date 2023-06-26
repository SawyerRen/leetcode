package com.meta1.q1500;

import java.util.ArrayList;
import java.util.List;

public class Q1570 {
    class SparseVector {
        class Node {
            int index;
            int value;

            public Node(int index, int value) {
                this.index = index;
                this.value = value;
            }
        }

        List<Node> list = new ArrayList<>();

        SparseVector(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) list.add(new Node(i, nums[i]));
            }
        }

        // Return the dotProduct of two sparse vectors
        public int dotProduct(SparseVector vec) {
            List<Node> list1 = this.list;
            List<Node> list2 = vec.list;
            int i = 0, j = 0;
            int res = 0;
            while (i < list1.size() && j < list2.size()) {
                Node n1 = list1.get(i);
                Node n2 = list2.get(j);
                if (n1.index == n2.index) {
                    res += n1.value * n2.value;
                    i++;
                    j++;
                } else if (n1.index < n2.index) {
                    i++;
                } else {
                    j++;
                }
            }
            return res;
        }
    }
}
