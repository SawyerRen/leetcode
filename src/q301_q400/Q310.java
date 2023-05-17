package q301_q400;

import java.util.*;

public class Q310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>();
            res.add(0);
            return res;
        }
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] edge : edges) {
            map.putIfAbsent(edge[0], new HashSet<>());
            map.putIfAbsent(edge[1], new HashSet<>());
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }
        Queue<Integer> queue = new LinkedList<>();
        for (Integer e : map.keySet()) {
            if (map.get(e).size() == 1) queue.add(e);
        }
        List<Integer> res = new ArrayList<>(queue);
        while (!queue.isEmpty()) {
            res = new ArrayList<>(queue);
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer e1 = queue.poll();
                for (Integer e2 : map.get(e1)) {
                    map.get(e2).remove(e1);
                    if (map.get(e2).size() == 1) queue.add(e2);
                }
            }
        }
        return res;
    }
}
