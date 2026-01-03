// class Solution {
//     public int uniquePathsIII(int[][] grid) {
//         int m = grid.length;
//         int n = grid[0].length;
//         if(m==1 && n==1){
//             if(grid[0][0]==-1){
//                 return 0;
//             }
//         }
//         int srow=0;
//         int scol=0;
//         int erow=0;
//         int ecol=0;
//         for(int i=0; i< m ;i++){
//             for(int j =0;j<n;j++){
//                 if(grid[i][j]==1){
//                     srow=i;
//                     scol=j;
//                 }
//                 if(grid[i][j]==2){
//                     erow=i;
//                     ecol=j;
//                 }
//             }
//         }
//         return solve(grid,srow,scol,erow,ecol,m,n);
//     }
//     public int solve(int[][] grid,int srow,int scol, int erow,int ecol,int m,int n){
//         if(erow<0 || ecol <0) return 0;
//         if(erow>m || ecol >n) return 0;
//         if(grid[erow][ecol]==1) return 1;

//         int up=solve(grid,srow,scol,erow-1,ecol,m,n);
//         int down=solve(grid,srow,scol,erow+1,ecol,m,n);
//         int left=solve(grid,srow,scol,erow,ecol-1,m,n);
//         int right=solve(grid,srow,scol,erow,ecol+1,m,n);
//         return up+down+left+right;
//     }

// }

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
