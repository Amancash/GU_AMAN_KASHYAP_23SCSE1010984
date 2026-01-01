class Solution {
    int[] dp;
    public int climbStairs(int n) {
        dp=new int[n+1];
        for(int i =0 ;i<n+1;i++){
            dp[i]=-1;
        }
        return solve(n);
    }
    public int solve(int n){
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        int left = solve(n-1);
        int right = solve(n-2);
        dp[n]= left+right;
        return dp[n];
    }
}