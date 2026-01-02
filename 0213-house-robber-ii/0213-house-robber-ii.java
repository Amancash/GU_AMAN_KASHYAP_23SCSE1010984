class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n==1) return nums[0];
        int[] temp1 = new int[n - 1];
        for (int i = 1; i < n; i++) {
            temp1[i - 1] = nums[i];
        }
        int[] temp2 = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            temp2[i] = nums[i];
        }

        int ans1=solve (temp1,temp1.length-1);
        int ans2=solve (temp2,temp2.length-1);
        return Math.max(ans1,ans2);
    }
    public int solve(int[] arr, int i){
        // if(i==0) return arr[0];
        // if(i<0) return 0;
        // int take = arr[i] +solve(arr,i-2);
        // int nottake = 0+solve(arr,i-1);
        // return Math.max(take,nottake);


        int prev =arr[0];
        int prev2= 0;
        for(int j =1 ; j<arr.length ; j++){
            int take = arr[j] + prev2;;
            // if(j>1) take 
            int nottake = 0+prev;
             int curr = Math.max(take,nottake);
            
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}