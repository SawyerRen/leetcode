package q201_q300;

public class Q261 {
    class UnionFind {
        int[] parents;
        int size;

        public UnionFind(int n) {
            parents = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
            }
            size = n;
        }

        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            return i;
        }

        boolean union(int i, int j) {
            int p1 = find(i), p2 = find(j);
            if (p1 == p2) return false;
            parents[p2] = p1;
            size--;
            return true;
        }
    }

    public boolean validTree(int n, int[][] edges) {
        UnionFind uf = new UnionFind(n);
        for (int[] edge : edges) {
            if (!uf.union(edge[0], edge[1])) return false;
        }
        return uf.size == 1;
    }
}
