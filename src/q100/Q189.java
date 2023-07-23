package q100;

public class Q189 {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        revertArray(nums, 0, nums.length - 1);
        revertArray(nums, 0, k - 1);
        revertArray(nums, k, nums.length - 1);
    }

    private void revertArray(int[] nums, int i, int j) {
        while (i < j) {
            int n = nums[i];
            nums[i] = nums[j];
            nums[j] = n;
            i++;
            j--;
        }
    }
}
