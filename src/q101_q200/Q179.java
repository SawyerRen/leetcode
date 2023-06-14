package q101_q200;

import java.util.Arrays;

public class Q179 {
    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        StringBuilder builder = new StringBuilder();
        for (String s : arr) {
            builder.append(s);
        }
        if (builder.charAt(0) == '0') return "0";
        return builder.toString();
    }
}
