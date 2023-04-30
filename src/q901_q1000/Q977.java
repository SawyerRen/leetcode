package q901_q1000;

public class Q977 {
    public int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        int index = nums.length - 1;
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int l = Math.abs(nums[i]);
            int r = Math.abs(nums[j]);
            if (l > r) {
                res[index--] = l * l;
                i++;
            } else {
                res[index--] = r * r;
                j--;
            }
        }
        return res;
    }
}
