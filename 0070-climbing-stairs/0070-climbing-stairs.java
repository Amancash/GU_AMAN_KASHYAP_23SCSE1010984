class Solution {












// recursive approch
// public int climbStairs(int n) {
//         return solve(n);
//     }
//     public int solve(int n){
//         if(n==0) return 1;
//         if(n==1) return 1;
//         int left = solve(n-1);
//         int right = solve(n-2);
//         return left+right;
//     }

// solve(int n){
//     if(n==0) return 1;
//     if(n==1) return 1;
//     int one = solve(n-1);
//     int two = solve(n-2);
//     return one + two;
// }





//dynamic programming approch
int[] dp;
public int climbStairs(int n) {
    //     dp=new int[n+1];
    //     for(int i =0 ;i<n+1;i++){
    //         dp[i]=-1;
    //     }
    //     return solve(n);
    // }
    // public int solve(int n){
    //     if(n==0) return 1;
    //     if(n==1) return 1;
    //     if(dp[n]!=-1) return dp[n];
    //     int left = solve(n-1);
    //     int right = solve(n-2);
    //     dp[n]= left+right;
    //     return dp[n];
    // }
    dp = new int[n+1];
    Arrays.fill(dp,-1);
    return solve(n);

}
public int solve(int n){
    if(n==0){
        return 1;
    }
    if(n<0) return 0;
    if(dp[n]!=-1) return dp[n];
    int first = solve(n-1);
    int second = solve(n-2);
     dp[n] =first + second;
     return dp[n];
}


// //tabulation approch
// int[] dp;
//     public int climbStairs(int n) {
//         dp=new int[n+1];
//         dp[0]=1;
//         dp[1]=1;
//         for(int i =2 ;i<n+1;i++){
//             dp[i]=dp[i-1]+dp[i-2];
//         }
//         return dp[n];
//     }
}