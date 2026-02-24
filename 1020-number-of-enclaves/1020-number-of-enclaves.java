class Solution {
    int n;
    int m;
    int[][] vis;
    int[] drow={-1,0,1,0};
    int[] dcol ={0,-1,0,1};
    public int numEnclaves(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        vis = new int[n][m];

        for(int j =0 ; j < m ; j++){

            if(vis[0][j]!=1 && grid[0][j]==1) dfs(0,j,grid);
            if(vis[n-1][j]!=1 && grid[n-1][j]==1) dfs(n-1,j,grid);
        }
        for(int i =0 ; i < n ; i++){

            if (vis[i][0]!=1 && grid[i][0]==1) dfs(i,0,grid);
            if(vis[i][m-1]!=1 && grid[i][m-1]==1) dfs(i,m-1,grid);
        }

        int count=0;
        for(int i =0 ; i< n ; i++){
            for(int j =0 ;j<m ; j++){
                if(vis[i][j] == 0 && grid[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }
    
    public void dfs(int row, int col,int[][] grid){
        vis[row][col]=1;
        for(int i =0 ;i<4 ; i++){
            int nrow = row+drow[i];
            int ncol = col + dcol[i];

            if(nrow >= 0 && nrow<n && ncol>=0 && ncol < m && vis[nrow][ncol] !=1 && grid[nrow][ncol]==1){
                dfs(nrow,ncol,grid);
            }
        }
    }
}