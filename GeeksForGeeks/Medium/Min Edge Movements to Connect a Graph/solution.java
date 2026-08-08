class Solution {

    class DSU {
        int[] parent, rank;

        DSU(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        boolean union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) return false;

            if (rank[pa] < rank[pb]) {
                parent[pa] = pb;
            } else if (rank[pb] < rank[pa]) {
                parent[pb] = pa;
            } else {
                parent[pb] = pa;
                rank[pa]++;
            }
            return true;
        }
    }

    int minEdgesReq(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int extra = 0;

        for (int[] edge : edges) {
            if (!dsu.union(edge[0], edge[1])) {
                extra++;
            }
        }

        int components = 0;
        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i) {
                components++;
            }
        }

        int required = components - 1;

        return extra >= required ? required : -1;
    }
}