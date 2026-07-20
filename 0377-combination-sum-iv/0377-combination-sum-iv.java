class Solution {
    int n;
    int[][] t;
    public int combinationSum4(int[] nums, int target) {
        n=nums.length;
        t = new int[201][1001];
        for(int i =0 ; i<t.length ;i++){
            for(int j =0 ; j<t[0].length ;j++){
                t[i][j]=-1;
            }
        }
        return solve(0 , nums,target);
    }

    public int solve(int idx ,int[] nums, int target){
        if(target ==0){
            return 1;
        }
        if(idx >= n ){
            return 0;
        }
        if (target < 0) {
    return 0;
}
        if(t[idx][target] !=-1) return t[idx][target];
        int take = solve(0, nums, target-nums[idx]);
        int not = solve(idx+1 , nums,  target);

        return t[idx][target] = take + not;
    }
}