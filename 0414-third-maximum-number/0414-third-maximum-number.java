class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int dis=1;
        int last=nums[nums.length-1];
        for(int i=nums.length-2 ; i>=0;i--){
            if(nums[i] != last){
                dis++;
                last=nums[i];
            }
            if(dis==3) return nums[i];

        }
        return nums[nums.length-1];

    }
}