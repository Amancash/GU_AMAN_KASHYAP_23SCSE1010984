class Solution {
    // int[] dp;
    public int rob(int[] nums) {
        // dp=new int[nums.length];
        // for(int i =0 ;i<nums.length;i++){
        //     dp[i]=-1;
        // }
        // dp[0]=nums[0];
        // for(int i =1 ;i<nums.length;i++){
        //     int take=nums[i];
        //     if(i>1) take +=dp[i-2];
        //     int nottake = 0+ dp[i-1];

        //     dp[i]=Math.max(take,nottake);
        // }
        // return dp[nums.length-1];
        // return solve(nums,nums.length-1);


    int prev=nums[0];
    int prev2 = 0;
    for(int i =1 ;i<nums.length ;i++){
        int take = nums[i];
        if(i>1) take += prev2;
        int nottake = 0+ prev;

        int curr = Math.max(take,nottake);
        prev2=prev;
        prev=curr;
    }
    return prev;
    }
    // public int solve(int[] arr,int i){
    //     if(i==0) return arr[i];
    //     if(i<0) return 0;
    //     int take=arr[i]+solve(arr,i-2);
    //     int nottake=0+solve(arr,i-1);
    //     return Math.max(take,nottake);
    // }

    // public int solve(int[] arr,int i){
    //     if(i==0) return arr[i];
    //     if(i<0) return 0;
    //     if(dp[i] !=-1) return dp[i];
    //     int take = arr[i] + solve(arr,i-2);
    //     int nottake = 0+ solve(arr,i-1);
    //     dp[i]= Math.max(take,nottake);
    //     return dp[i];
    // }

    
    
}