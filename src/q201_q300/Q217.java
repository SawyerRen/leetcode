package q201_q300;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Q217 {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) return true;
            set.add(num);
        }
        return false;
    }
}
