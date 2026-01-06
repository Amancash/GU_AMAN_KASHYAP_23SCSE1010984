class Solution {
    int[][][] dp;
    public int cherryPickup(int[][] grid) {
        int m=grid.length;
        int n = grid[0].length;
        dp=new int[m][n][n];
        for(int i =0; i<m ; i++){
            for(int j =0 ;j<n ; j++){
                for(int k =0 ;k<n ; k++){
                    dp[i][j][k]=-1;
                }
            }
        }
        return solve(grid,0,0,n-1,m,n);
    }
    public int solve (int [][] grid ,int i ,int j1,int j2,int m,int n){
        if(j1<0 || j1>=n || j2<0 || j2>=n){
            return Integer.MIN_VALUE;
        }
        if (i == m - 1) {
            if (j1 == j2) return grid[i][j1];
            else return grid[i][j1] + grid[i][j2];
        }  
        if(dp[i][j1][j2]!=-1) return dp[i][j1][j2];
        int maxi=0;
        for(int d =-1 ;d<2;d++){
            for(int j=-1;j<2;j++){
                if(j1==j2){
                    maxi = Math.max(maxi,grid[i][j1]+solve(grid,i+1,j1+d,j2+j,m,n));
                }else{
                     maxi = Math.max(maxi,grid[i][j1] + grid[i][j2] + solve(grid,i+1,j1+d,j2+j,m,n));
                }
            }
        }

       return dp[i][j1][j2] = maxi;
    }
}