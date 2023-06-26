package com.meta1.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage {
        Queue<Integer> queue;
        int capacity;
        double sum = 0;

        public MovingAverage(int size) {
            queue = new LinkedList<>();
            this.capacity = size;
        }

        public double next(int val) {
            queue.add(val);
            sum += val;
            if (queue.size() > capacity) {
                sum -= queue.poll();
            }
            return sum / queue.size();
        }
    }
}
