class Solution {

    int[] row = {-1, 1, 0, 0};
    int[] col = {0, 0, -1, 1};

    public int longestPath(int[][] mat, int xs, int ys, int xd, int yd) {

        int n = mat.length;
        int m = mat[0].length;

        if (mat[xs][ys] == 0 || mat[xd][yd] == 0)
            return -1;

        boolean[][] visited = new boolean[n][m];

        return dfs(mat, visited, xs, ys, xd, yd);
    }

    private int dfs(int[][] mat, boolean[][] visited,
                    int x, int y, int xd, int yd) {

        if (x == xd && y == yd)
            return 0;

        visited[x][y] = true;

        int max = -1;

        for (int i = 0; i < 4; i++) {

            int nx = x + row[i];
            int ny = y + col[i];

            if (isSafe(mat, visited, nx, ny)) {

                int path = dfs(mat, visited, nx, ny, xd, yd);

                if (path != -1) {
                    max = Math.max(max, path + 1);
                }
            }
        }

        visited[x][y] = false;

        return max;
    }

    private boolean isSafe(int[][] mat, boolean[][] visited,
                           int x, int y) {

        int n = mat.length;
        int m = mat[0].length;

        return x >= 0 && x < n &&
               y >= 0 && y < m &&
               mat[x][y] == 1 &&
               !visited[x][y];
    }
}