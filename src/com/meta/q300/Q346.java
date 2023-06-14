package com.meta.q300;

import java.util.LinkedList;
import java.util.Queue;

public class Q346 {
    class MovingAverage1 {
        Queue<Integer> queue = new LinkedList<>();
        int size = 0;
        int sum = 0;

        public MovingAverage1(int size) {
            this.size = size;
        }

        public double next(int val) {
            if (queue.size() == this.size) {
                sum -= queue.poll();
            }
            queue.add(val);
            sum += val;
            return (double) sum / queue.size();
        }
    }
}