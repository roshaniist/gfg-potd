class Solution {
    static final int MOD = 1000000007;

    int minOperations(int[] b) {
        int n = b.length;

        // Smallest Prime Factor (SPF)
        int[] spf = new int[n + 1];
        for (int i = 0; i <= n; i++) spf[i] = i;

        for (int i = 2; i * i <= n; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    if (spf[j] == j) spf[j] = i;
                }
            }
        }

        boolean[] vis = new boolean[n];
        int[] maxExp = new int[n + 1];

        // Find cycle lengths
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int cur = i;
                int len = 0;

                while (!vis[cur]) {
                    vis[cur] = true;
                    cur = b[cur] - 1; // convert to 0-based index
                    len++;
                }

                // Prime factorization of cycle length
                int x = len;
                while (x > 1) {
                    int p = spf[x];
                    int cnt = 0;
                    while (x % p == 0) {
                        x /= p;
                        cnt++;
                    }
                    maxExp[p] = Math.max(maxExp[p], cnt);
                }
            }
        }

        long ans = 1;

        // Build LCM from prime powers
        for (int p = 2; p <= n; p++) {
            if (maxExp[p] > 0) {
                for (int i = 0; i < maxExp[p]; i++) {
                    ans = (ans * p) % MOD;
                }
            }
        }

        return (int) ans;
    }
}