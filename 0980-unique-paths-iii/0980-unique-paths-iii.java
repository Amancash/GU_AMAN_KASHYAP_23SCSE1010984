class Solution {
    int paths = 0;
    int empty = 0;
    int m, n;

    public int uniquePathsIII(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        int sr = 0, sc = 0;

        // find start and count non-obstacle cells
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) empty++;
                if (grid[i][j] == 1) {
                    sr = i;
                    sc = j;
                }
            }
        }

        dfs(grid, sr, sc, empty);
        return paths;
    }

    void dfs(int[][] grid, int r, int c, int remain) {
        // boundary / obstacle check
        if (r < 0 || c < 0 || r >= m || c >= n || grid[r][c] == -1)
            return;

        // reached end
        if (grid[r][c] == 2) {
            if (remain == 1) paths++;
            return;
        }

        // mark visited
        int temp = grid[r][c];
        grid[r][c] = -1;

        dfs(grid, r - 1, c, remain - 1); // up
        dfs(grid, r + 1, c, remain - 1); // down
        dfs(grid, r, c - 1, remain - 1); // left
        dfs(grid, r, c + 1, remain - 1); // right

        // backtrack
        grid[r][c] = temp;
    }
}
