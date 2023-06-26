package com.meta1.q200;

import java.util.PriorityQueue;
import java.util.Random;

public class Q215 {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        k = nums.length - k;
        while (left < right) {
            int pivotIndex = partition(nums, left, right);
            if (pivotIndex < k) left = pivotIndex + 1;
            else right = pivotIndex;
        }
        return nums[k];
    }

    private int partition(int[] nums, int left, int right) {
        int randomIndex = new Random().nextInt(right - left) + left;
        swap(nums, left, randomIndex);
        int pivot = nums[left];
        int i = left, j = right;
        while (i < j) {
            while (i < j && nums[j] >= pivot) j--;
            while (i < j && nums[i] <= pivot) i++;
            if (i < j) swap(nums, i, j);
        }
        swap(nums, left, i);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

    public int findKthLargest1(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) pq.poll();
        }
        return pq.peek();
    }
}
