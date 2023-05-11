package q901_q1000;

import java.util.PriorityQueue;
import java.util.Random;

public class Q973 {
    public int[][] kClosest(int[][] points, int k) {
        int left = 0, right = points.length - 1;
        while (left < right) {
            int index = partition(points, left, right);
            if (index > k) right = index;
            else left = index + 1;
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = points[i];
        }
        return res;
    }

    private int partition(int[][] points, int left, int right) {
        int randomIndex = new Random().nextInt(right - left + 1) + left;
        swap(points, left, randomIndex);
        int pivot = calDist(points[left]);
        int i = left, j = right;
        while (i < j) {
            while (i < j && calDist(points[j]) >= pivot) j--;
            while (i < j && calDist(points[i]) <= pivot) i++;
            if (i < j) {
                swap(points, i, j);
            }
        }
        swap(points, left, i);
        return i;
    }

    private void swap(int[][] points, int i, int j) {
        int[] t = points[i];
        points[i] = points[j];
        points[j] = t;
    }

    public int[][] kClosest1(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> calDist(b) - calDist(a));
        for (int[] point : points) {
            pq.add(point);
            if (pq.size() > k) pq.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll();
        }
        return res;
    }

    int calDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
}
