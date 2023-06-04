package q601_q700;

import java.util.ArrayList;
import java.util.List;

public class Q658 {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int left = 0, right = arr.length - k;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < left + k; i++) {
            res.add(arr[i]);
        }
        return res;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        int left = 0, right = arr.length - 1;
        while (right - left + 1 > k) {
            int dist1 = Math.abs(arr[left] - x);
            int dist2 = Math.abs(arr[right] - x);
            if (dist1 > dist2) {
                left++;
            } else {
                right--;
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = left; i < right + 1; i++) {
            res.add(arr[i]);
        }
        return res;
    }
}
