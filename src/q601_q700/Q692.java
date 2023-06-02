package q601_q700;

import java.util.*;

public class Q692 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List[] lists = new ArrayList[words.length + 1];
        for (String word : map.keySet()) {
            int count = map.get(word);
            if (lists[count] == null) lists[count] = new ArrayList();
            lists[count].add(word);
        }
        List<String> res = new ArrayList<>();
        for (int i = lists.length - 1; i > 0; i--) {
            if (lists[i] != null) {
                List<String> list = lists[i];
                list.sort((a, b) -> a.compareTo(b));
                for (String s : list) {
                    if (res.size() < k) res.add(s);
                    else break;
                }
            }
            if (res.size() == k) break;
        }
        return res;
    }

    public List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> map.get(a) != map.get(b) ? map.get(a) - map.get(b) : b.compareTo(a));
        for (String s : map.keySet()) {
            pq.add(s);
            if (pq.size() > k) pq.poll();
        }
        LinkedList<String> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.addFirst(pq.poll());
        }
        return res;
    }
}
