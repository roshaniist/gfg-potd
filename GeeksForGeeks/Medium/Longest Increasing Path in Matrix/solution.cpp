class Solution {
  public:

    vector<vector<int>> directions{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    int dfs(int i, int j, int n, int m, vector<vector<int>>& matrix, vector<vector<int>>& dp){


        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        int ans = 1;

        for (auto& dir : directions) {

            int x = i + dir[0];
            int y = j + dir[1];

            if (x >= n || x < 0 || y >= m || y < 0  || matrix[x][y] <= matrix[i][j]) continue;

            ans = max(ans, 1 + dfs(x, y, n, m, matrix, dp));
        }

        return dp[i][j] = ans;
    }
    int longIncPath(vector<vector<int>> &matrix, int n, int m) {
        // code here

        vector<vector<int>> dp(n, vector<int>(m, -1));

        int ans = 1;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {

                ans = max(ans, dfs(i, j, n, m, matrix, dp));
            }
        }

        return ans;
    }
};