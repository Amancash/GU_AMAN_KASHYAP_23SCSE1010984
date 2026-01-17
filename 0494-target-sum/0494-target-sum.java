class Solution {
    public int findTargetSumWays(int[] nums, int diff) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        if (Math.abs(diff) > sum) return 0;
        if ((sum + diff) % 2 != 0) return 0;

        int t = (sum + diff) / 2;

        return solve(nums, t, n - 1);
    }
    public int solve(int[] arr, int t , int i){
        
        if(i==0){
            if(t==0 && arr[0]==0) return 2;
            if(t==0 || t == arr[0]) return 1;
            return 0;
        }
        if(i<0) return 0;
        int not = solve(arr,t,i-1);
        int pick = solve(arr,t-arr[i],i-1);
        return not + pick ;
    }
}



