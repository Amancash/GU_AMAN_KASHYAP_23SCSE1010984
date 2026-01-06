// class Solution {
//     int[][] dp;
//     public int minFallingPathSum(int[][] arr) {
//         int n = arr.length;
//         dp= new int[n][n];
//         int ans = Integer.MAX_VALUE;
//         for (int j = 0; j < n; j++) {
//             ans = Math.min(ans, solve(arr, 0, j, n));
//         }
//         return ans;       
//     }
//     public int solve(int[][] arr,int i,int j,int n){
//         if(i==n-1) return dp[n-1][j]=arr[n-1][j];
//         if(j<0 || j>=n) return dp[i][j]=Integer.MAX_VALUE;
//         for(int k =0 ; k < n ;k++){
//             dp[0][k]=arr[0][k];
//         }
//         for(int k =1 ; k<n ; k++){
//         int down =dp[i+1][j];
//         int ldown=dp[i+1][j-1];
//         int rdown = dp[i+1][j+1];
//         dp[i][j]=dp[i][j] + Math.min(Math.min(down, ldown), rdown);
//         }
// //         return dp[i][j];
// //     }
// // }
// class Solution {
//     int[][] dp;
//     public int minFallingPathSum(int[][] arr) {
//         int n = arr.length;
//         int ans = Integer.MAX_VALUE;
//         dp=new int[n][n];
//         for(int i =0 ; i<n;i++){
//             for(int j=0 ; j<n;j++){
//                 dp[i][j]=-1;
//             }
//         }
//         for (int j = 0; j < n; j++) {
//             ans = Math.min(ans, solve(arr, 0, j, n));
//         }
//         return ans;
//     }
//     public int solve(int[][] arr,int i,int j,int n){

//         if (j < 0 || j >= n) return Integer.MAX_VALUE;

//         // reached last row
//         if (i == n - 1) return arr[i][j];
//         if(dp[i][j]!=-1) return dp[i][j];
//         int down =solve(arr,i+1,j,n);
//         int ldown=solve(arr,i+1,j-1,n);
//         int rdown = solve(arr,i+1,j+1,n);
//         return dp[i][j]= arr[i][j] + Math.min(Math.min(down, ldown), rdown);
//     }
// }
class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];

        // initialize first row
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }

        // fill dp table
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i-1][j];
                int leftDiag = j > 0 ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightDiag = j < n-1 ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiag, rightDiag));
            }
        }

        // answer = min in last row
        int ans = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            ans = Math.min(ans, dp[n-1][j]);
        }

        return ans;
    }
}
