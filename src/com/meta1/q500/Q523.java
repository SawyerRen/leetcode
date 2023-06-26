package com.meta1.q500;

import java.util.HashMap;
import java.util.Map;

public class Q523 {
    public boolean checkSubarraySum(int[] nums, int k) {
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int mod = preSum % k;
            if (map.containsKey(mod) && i - map.get(mod) >= 2) return true;
            map.putIfAbsent(mod, i);
        }
        return false;
    }
}
