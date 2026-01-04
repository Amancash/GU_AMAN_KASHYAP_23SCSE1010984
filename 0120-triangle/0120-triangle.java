class Solution {
    int[] dp;
    public int minimumTotal(List<List<Integer>> arr) {
        int n = arr.size();
        dp = new int[n];
        for(int j = 0 ; j<n;j++){
            dp[j] = arr.get(n - 1).get(j);
        }

        for(int i=n-2 ; i>=0 ;i--){
            int[] temp = new int[n];
            for(int j=i ; j>=0 ;j--){
                int down=arr.get(i).get(j) +dp[j];
                int rdown=arr.get(i).get(j) +dp[j+1];
                temp[j]= Math.min(down, rdown);
            }
            dp=temp;
        }
        return dp[0];



// Tabulation approch
        // int n = arr.size();
        // dp = new int[n][n];
        // for(int j = 0 ; j<n;j++){
        //     dp[n-1][j] = arr.get(n-1).get(j);
        // }

        // for(int i=n-2 ; i>=0 ;i--){
        //     for(int j=i ; j>=0 ;j--){
        //         int down=arr.get(i).get(j) +dp[i+1][j];
        //         int rdown=arr.get(i).get(j) +dp[i+1][j+1];
        //         dp[i][j]= Math.min(down, rdown);
        //     }
        // }
        // return dp[0][0];



// memoization approch
    //     int n=triangle.size();
    //     dp=new int[n][n];
    //     for(int i =0 ;i<n;i++){
    //         for(int j=0 ;j<n;j++){
    //             dp[i][j]=-1;
    //         }
    //     }
    //     return solve(triangle,0,0,n);
    // }
    // public int solve (List<List<Integer>> arr,int i,int j,int n){
    //     if (i == n - 1) {
    //         return arr.get(i).get(j);
    //     }
    //     if(dp[i][j] != -1) return dp[i][j];
    //     int down=arr.get(i).get(j) +solve(arr, i+1,j,n);
    //     // int ldown=solve(arr, i+1,j-1,n);
    //     int rdown=arr.get(i).get(j) +solve(arr,i+1,j+1,n);
    //     return dp[i][j]= Math.min(down, rdown);
    }
}