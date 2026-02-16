class Solution {
    boolean[][] vis;
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        vis = new boolean[n][m];
        int count=0;
        for(int i =0 ; i <n ; i ++){
            for(int j =0 ; j <m ; j ++){
                if(grid[i][j] == '1' && !vis[i][j]){
                    count++;
                    dfs(i,j,grid);
                }
        } 
        }
        return count;
        
    }
    public void dfs(int i , int j ,char[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if (i < 0 || j < 0 || i >= n || j >= m) return;
        if (grid[i][j] == '0' || vis[i][j]) return;
        vis[i][j]=true;
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
    }
}



