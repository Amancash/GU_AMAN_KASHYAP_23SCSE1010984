class Solution {
    public int findMin(int[] nums) {
        if(nums.length==1) return nums[0];
        int ans = Integer.MAX_VALUE;
        int low =0 ;
        int high = nums.length-1;
        return solve (low , high , nums, ans);
        
    }
    public int solve(int i , int j ,int[] arr , int ans){
        if(i==j){
            ans = Math.min(ans, arr[i]);
            return ans;
        }
        if(i>=j){
            return ans;
        }
        int mid = i+(j-i)/2;
        if(arr[i]<=arr[mid]){
            ans = Math.min(ans , arr[i]);
            return solve(mid+1 , j , arr, ans);
        }
        else{
            ans = Math.min(ans, arr[mid]);
            return solve(i,mid-1,arr,ans);
        }


    }
}