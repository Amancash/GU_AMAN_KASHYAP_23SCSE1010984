class Solution {
    public long maxAlternatingSum(int[] nums) {
        return solve(nums);
    }
    public static long solve(int[] nums) {
        long addsum =0;
        long subsum =0;
        for(int i =0 ; i < nums.length ;i++){
        long nextadd = Math.max(subsum - nums[i] , addsum);
            long nextsub = Math.max(addsum + nums[i], subsum);
            addsum = nextadd;
            subsum = nextsub;
        }
        return Math.max(addsum,subsum);
    }
}