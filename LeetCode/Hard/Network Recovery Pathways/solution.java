class Solution {
    public int findMaxPathScore(int[][] edges, boolean[] online, long k) {
        int n = online.length;

        @SuppressWarnings("unchecked")
        java.util.ArrayList<int[]>[] graph = new java.util.ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new java.util.ArrayList<>();

        int[] indegree = new int[n];
        int maxCost = 0;

        for (int[] e : edges) {
            graph[e[0]].add(new int[]{e[1], e[2]});
            indegree[e[1]]++;
            maxCost = Math.max(maxCost, e[2]);
        }

        // Topological order
        int[] topo = new int[n];
        int idx = 0;
        java.util.ArrayDeque<Integer> q = new java.util.ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int u = q.poll();
            topo[idx++] = u;
            for (int[] e : graph[u]) {
                if (--indegree[e[0]] == 0) {
                    q.offer(e[0]);
                }
            }
        }

        int lo = 0, hi = maxCost;
        int ans = -1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (canReach(mid, graph, topo, online, k)) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        return ans;
    }

    private boolean canReach(int limit,
                             java.util.ArrayList<int[]>[] graph,
                             int[] topo,
                             boolean[] online,
                             long k) {

        int n = online.length;
        long INF = Long.MAX_VALUE / 4;
        long[] dist = new long[n];
        java.util.Arrays.fill(dist, INF);
        dist[0] = 0;

        for (int u : topo) {
            if (dist[u] == INF) continue;

            // Intermediate offline nodes cannot be used
            if (u != 0 && u != n - 1 && !online[u]) continue;

            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];

                if (w < limit) continue;
                if (v != n - 1 && !online[v]) continue;

                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                }
            }
        }

        return dist[n - 1] <= k;
    }
}