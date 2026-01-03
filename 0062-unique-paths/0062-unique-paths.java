class Solution {
    // int[][] dp;
    public int uniquePaths(int m, int n) {
       int[] dp= new int[n];
       for(int i=0 ; i<m;i++){
        int[] temp = new int[n];
        for(int j=0 ; j<n ;j++){
            if(i==0 && j==0) temp[j]=1;
            else{
                int up=0;
                int left=0;
                if(i>0) up=dp[j];
                if(j>0) left=temp[j-1];
                temp[j]=up+left;
            }
        }
        dp=temp;
       }
       return dp[n-1];
        // for(int i =0;i<m;i++){
        //     for(int j=0 ;j<n;j++){
        //         dp[i][j]=-1;
        //     }
        // }
        // return solve(m,n);
    }
    // Tabulation approch
    // public int solve(int m,int n){
    //     dp = new int[m][n];
    //     dp[0][0]=1;
    //     for(int i =0 ; i<m ;i++){
    //         for(int j=0;j<n ;j++){
    //             if(i==0 && j==0){
    //                 dp[0][0]=1;
    //             }
    //             else{
    //                 int up=0;
    //                 int left=0;
    //             if(i>0) {
    //                 up=dp[i-1][j];}
    //             if(j>0) {
    //                 left=dp[i][j-1];}
                
    //             dp[i][j]=up+left;
    //             }
    //         }
    //     }
    //     return dp[m-1][n-1];
    // }




    // DP approch
    // public int solve(int i ,int j){
    //     if(i==0 && j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     if(dp[i][j]!=-1) return dp[i][j];
    //     int up=solve(i-1,j);
    //     int left=solve(i,j-1);
    //     dp[i][j]=up+left;
    //     return dp[i][j];
    // }

    // recursion approch
    // public int solve(int i,int j){
    //     if(i==0&&j==0) return 1;
    //     if(i<0 || j<0) return 0;
    //     int up=solve(i-1,j);
    //     int left=solve(i,j-1);
    //     return up+left;
    // }
}