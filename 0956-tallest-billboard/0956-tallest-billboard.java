// class Solution {
//     int[][] dp;
//     public int tallestBillboard(int[] rods) {
//         int n = rods.length;
//         int sum = 0;
//         for (int r : rods) sum += r;
//         dp = new int[n + 1][2 * sum + 1];

//         for (int i = 0; i <= n; i++) {
//             for (int d = 0; d <= 2 * sum; d++) {
//                 dp[i][d] = -1;
//             }
//         }
//         return solve(rods,0,0);
//     }
//     public int solve(int[] arr, int i,int diff){
//         if(i==arr.length) return diff==0 ? 0: Integer.MIN_VALUE;
//         if(dp[i][diff]!=0) return dp[i][diff];
//         int skip = solve(arr,i+1,diff);
//         int left = arr[i]+solve(arr,i+1,diff+arr[i]);
//         int right = solve(arr,i+1,diff-arr[i]);
//         int ans = Math.max(skip, Math.max(left, right));
//         return ans;
//     }
// }

class Solution {
    public int tallestBillboard(int[] rods) {
        int n = rods.length;
        int sum = 0;
        for (int r : rods) sum += r;

        int offset = sum;
        int[][] dp = new int[n + 1][2 * sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int d = 0; d <= 2 * sum; d++) {
                dp[i][d] = -1;
            }
        }

        dp[0][offset] = 0; // no rods, diff = 0

        for (int i = 1; i <= n; i++) {
            int rod = rods[i - 1];

            for (int d = 0; d <= 2 * sum; d++) {
                if (dp[i - 1][d] < 0) continue;

                // SKIP
                dp[i][d] = Math.max(dp[i][d], dp[i - 1][d]);

                // LEFT
                dp[i][d + rod] = Math.max(
                        dp[i][d + rod],
                        dp[i - 1][d] + rod
                );

                // RIGHT
                dp[i][d - rod] = Math.max(
                        dp[i][d - rod],
                        dp[i - 1][d]
                );
            }
        }

        return dp[n][offset];
    }
}
