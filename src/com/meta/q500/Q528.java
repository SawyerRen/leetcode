package com.meta.q500;

import java.util.Random;

public class Q528 {
    class Solution {
        int[] preSum;

        public Solution(int[] w) {
            preSum = new int[w.length];
            int sum = 0;
            for (int i = 0; i < w.length; i++) {
                sum += w[i];
                preSum[i] = sum;
            }
        }

        public int pickIndex() {
            int target = new Random().nextInt(preSum[preSum.length - 1]) + 1;
            int left = 0, right = preSum.length - 1;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] >= target) right = mid;
                else left = mid + 1;
            }
            return left;
        }
    }

}
