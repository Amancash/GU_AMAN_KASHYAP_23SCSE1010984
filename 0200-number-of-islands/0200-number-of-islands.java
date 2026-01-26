class Solution {
    int m, n;
    boolean[][] visited;
    int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
    
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        int count = 0;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    dfs(grid, i, j);
                    count++;   // one island completed
                }
            }
        }
        return count;
    }
    
    private void dfs(char[][] grid, int x, int y) {
        visited[x][y] = true;
        
        for (int[] d : dirs) {
            int nx = x + d[0];
            int ny = y + d[1];
            
            if (nx < 0 || ny < 0 || nx >= m || ny >= n)
                continue;
            
            if (grid[nx][ny] == '1' && !visited[nx][ny]) {
                dfs(grid, nx, ny);
            }
        }
    }
}



