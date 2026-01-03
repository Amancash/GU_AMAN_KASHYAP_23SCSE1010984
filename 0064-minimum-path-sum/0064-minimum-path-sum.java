class Solution {
    int[][] dp;
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if(m==1&&n==1){
            return grid[0][0];
        }
        dp=new int[m][n];
        for(int i = 0; i<m;i++){
            for(int j =0 ;j<n;j++){
                dp[i][j]=-1;
            }
        }
        return solve(grid,m-1,n-1);
    }
    public int solve(int[][] grid,int m, int n){
        if(m==0 && n==0) return grid[0][0];
        if(m<0 || n< 0) return Integer.MAX_VALUE;
        if(dp[m][n]!=-1) return dp[m][n];
        int up = (m > 0) ? grid[m][n] + solve(grid, m - 1, n) : Integer.MAX_VALUE;
        int left =(n>0)? grid[m][n] + solve(grid,m,n-1) :Integer.MAX_VALUE;
        return dp[m][n]= Math.min(up,left);
    }
}