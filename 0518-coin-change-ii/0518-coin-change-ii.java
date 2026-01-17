class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        // base case: first coin
        for (int j = 0; j <= amount; j++) {
            dp[0][j] = (j % coins[0] == 0) ? 1 : 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                int not = dp[i - 1][j];
                int pick = 0;
                if (coins[i] <= j) {
                    pick = dp[i][j - coins[i]];
                }
                dp[i][j] = not + pick;
            }
        }

        return dp[n - 1][amount];
    }
}

//     public int solve(int[] arr, int t, int i ){
//         if(t==0) return 1;
//         if(i==0) return (t%arr[i]==0)? 1:0;
//         if(dp[i][t]!=-1){
//             return dp[i][t];
//         }
//         int not = solve(arr,t,i-1);
//         int pick =0;
//         if(t>=arr[i]){
//             pick =solve(arr,t-arr[i],i);
//         }
//         return dp[i][t]= not + pick;
//     }
// }

// class Solution {
//     int[][] dp ;
//     public int change(int amount, int[] coins) {
//         dp = new int[coins.length][amount+1];
//         for(int i=0;i<coins.length;i++){
//             for(int j=0;j<=amount;j++){
//                 dp[i][j] = -1;
//             }
//         }

//         return  solve(coins,amount,coins.length-1);
        
//     }
//     public int solve(int[] arr, int t, int i ){
//         if(t==0) return 1;
//         if(i==0) return (t%arr[i]==0)? 1:0;
//         if(dp[i][t]!=-1){
//             return dp[i][t];
//         }
//         int not = solve(arr,t,i-1);
//         int pick =0;
//         if(t>=arr[i]){
//             pick =solve(arr,t-arr[i],i);
//         }
//         return dp[i][t]= not + pick;
//     }
// }}