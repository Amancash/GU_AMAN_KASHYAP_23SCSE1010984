class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        int[] suf = new int[n];

        pre[0]=1;
        for(int i =1 ; i<n ; i++){
            pre[i]=pre[i-1]*nums[i-1];
        }
        suf[n-1]=1;
        for(int i = n-2 ; i>=0 ;i--){
            suf[i]=suf[i+1]*nums[i+1];
        }
        for(int i =0 ; i<n ;i++){
            nums[i]=pre[i]*suf[i];
        }
        return nums;
        // int n = nums.length ;
        // int prod =1;
        // for(int x : nums){
        //     prod*=x;
        // }
        // for(int i =0 ; i<n ;i++){
        //     nums[i]=prod/nums[i];
        // }
        // return nums;
        // int[] ans = new int[nums.length];
        // int n = nums.length;
        // ans[0] = 1;
        // for(int i = 1; i < n; i++){
        //     ans[i] = ans[i - 1] * nums[i - 1];
        // }
        // int right = 1;
        // for(int i = n - 1; i >= 0; i--){
        //     ans[i] = ans[i] * right;
        //     right = right * nums[i];
        // }
        // return ans;


        // int[] ans = new int[nums.length];
        // ans[0]=1;
        // for(int i =1 ; i < nums.length ;i++){
        //     ans[i] = nums[i-1]*ans[i-1];
        // }
        // int right =1;
        // for(int i =nums.length-1 ; i>=0 ;i--){
        //     ans[i]=ans[i]*right;
        //     right = right*nums[i];
        // }
        // return ans;
    }
}