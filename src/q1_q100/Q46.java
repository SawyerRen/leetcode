package q1_q100;

import java.util.ArrayList;
import java.util.List;

public class Q46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(res, new ArrayList<Integer>(), nums, new boolean[nums.length]);
        return res;
    }

    private void helper(List<List<Integer>> res, ArrayList<Integer> list, int[] nums, boolean[] visited) {
        if (list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            list.add(nums[i]);
            helper(res, list, nums, visited);
            visited[i] = false;
            list.remove(list.size() - 1);
        }
    }
}
