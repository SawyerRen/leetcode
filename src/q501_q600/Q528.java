package q501_q600;

import java.util.Random;

public class Q528 {
    class Solution {
        int[] preSum;

        public Solution(int[] w) {
            preSum = new int[w.length];
            int num = 0;
            for (int i = 0; i < preSum.length; i++) {
                num += w[i];
                preSum[i] = num;
            }
        }

        public int pickIndex() {
            int index = new Random().nextInt(preSum[preSum.length - 1]) + 1;
            int left = 0, right = preSum.length;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] < index) left = mid + 1;
                else right = mid;
            }
            return left;
        }
    }
}
