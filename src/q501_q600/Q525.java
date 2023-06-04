package q501_q600;

import java.util.HashMap;
import java.util.Map;

public class Q525 {
    public int findMaxLength(int[] nums) {
        int preSum = 0, res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(preSum)) {
                res = Math.max(res, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }
        return res;
    }
}
