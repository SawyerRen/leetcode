package q700_q800;

import java.util.*;

public class Q721 {
    class UnionFind {
        int[] parents;

        public UnionFind(int n) {
            this.parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i), q = find(j);
            if (p == q) return;
            parents[q] = p;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind(accounts.size());
        Map<String, Integer> mailIndexMap = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (mailIndexMap.containsKey(mail)) {
                    uf.union(i, mailIndexMap.get(mail));
                } else {
                    mailIndexMap.put(mail, i);
                }
            }
        }
        Map<Integer, List<String>> indexMailMap = new HashMap<>();
        for (String mail : mailIndexMap.keySet()) {
            int index = uf.find(mailIndexMap.get(mail));
            indexMailMap.putIfAbsent(index, new ArrayList<>());
            indexMailMap.get(index).add(mail);
        }
        List<List<String>> res = new ArrayList<>();
        for (Integer index : indexMailMap.keySet()) {
            List<String> list = indexMailMap.get(index);
            String name = accounts.get(index).get(0);
            list.sort((a, b) -> a.compareTo(b));
            list.add(0, name);
            res.add(list);
        }
        return res;
    }
}
