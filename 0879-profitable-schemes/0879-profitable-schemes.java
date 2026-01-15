// class Solution {
//     int[][][] dp;
//     public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
//         dp = new int[group.length][n + 1][minProfit + 1];

//         for (int i = 0; i < group.length; i++) {
//             for (int j = 0; j <= n; j++) {
//                 for (int k = 0; k <= minProfit; k++) {
//                     dp[i][j][k] = -1;
//                 }
//             }
//         }
//         return solve (n,minProfit,group , profit,group.length-1);
//     }
//     public int solve(int n, int minProfit, int[] group, int[] profit,int i){
//         if(i < 0) {
//             return minProfit == 0 ? 1 : 0;
//         }   
//         if(dp[i][n][minProfit]!=-1) return dp[i][n][minProfit];
//         int not = solve(n,minProfit,group , profit,i-1);
//         int take = 0;
//         if(n>=group[i]){
//         minProfit = Math.max(0, minProfit - profit[i]);
//             take = solve(n-group[i],minProfit,group , profit,i-1);
//         }
//         return dp[i][n][minProfit]= take+not;
        
//     }
// }

class Solution {
    static final int MOD = 1000000007;
    int[][][] dp;

    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        dp = new int[group.length][n + 1][minProfit + 1];

        for (int i = 0; i < group.length; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= minProfit; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }

        return solve(group.length - 1, n, minProfit, group, profit);
    }

    int solve(int i, int members, int profitLeft, int[] group, int[] profit) {
        if (i < 0) {
            return profitLeft == 0 ? 1 : 0;
        }

        if (dp[i][members][profitLeft] != -1)
            return dp[i][members][profitLeft];

        // NOT TAKE
        int ways = solve(i - 1, members, profitLeft, group, profit);

        // TAKE
        if (members >= group[i]) {
            int newProfit = Math.max(0, profitLeft - profit[i]);
            ways = (ways + solve(
                    i - 1,
                    members - group[i],
                    newProfit,
                    group,
                    profit
            )) % MOD;
        }

        return dp[i][members][profitLeft] = ways;
    }
}
