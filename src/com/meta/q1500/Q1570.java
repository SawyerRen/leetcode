package com.meta.q1500;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Q1570 {
    class SparseVector {
        class Node {
            int index;
            int val;

            public Node(int index, int val) {
                this.index = index;
                this.val = val;
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
            List<Node> list2 = vec.list;
            List<Node> list1 = this.list;
            int i = 0, j = 0;
            int res = 0;
            while (i < list1.size() && j < list2.size()) {
                Node n1 = list1.get(i);
                Node n2 = list2.get(j);
                if (n1.index < n2.index) {
                    i++;
                } else if (n1.index > n2.index) {
                    j++;
                } else {
                    res += n1.val * n2.val;
                    i++;
                    j++;
                }
            }
            return res;
        }
    }
}
