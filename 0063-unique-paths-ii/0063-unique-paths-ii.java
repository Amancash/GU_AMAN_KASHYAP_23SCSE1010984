class Solution {
    int[][] dp;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;        
        int n = obstacleGrid[0].length;
        if(m==1&& n==1){
            if(obstacleGrid[0][0]==1){
                return 0;
            }
        }
        dp=new int[m][n];
        for(int i =0 ;i<m;i++){
            for(int j=0 ;j<n ;j++){
                dp[i][j]=-1;
            }
        }
        return solve (obstacleGrid,m-1,n-1);
    }
    public int solve(int[][] obstacleGrid,int m,int n){
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        int up=0;
        int left=0;
        if(dp[m][n]!=-1) return dp[m][n];
        if(obstacleGrid[m][n]!=1){
            if(m>0){
            if(obstacleGrid[m-1][n]!=1){
                
            up = solve(obstacleGrid,m-1,n);
            }}
            if(n>0){
            if(obstacleGrid[m][n-1]!=1){
               
                left = solve(obstacleGrid,m,n-1);
            }}
        }
        dp[m][n]= up+left;
        return dp[m][n];
    }
}