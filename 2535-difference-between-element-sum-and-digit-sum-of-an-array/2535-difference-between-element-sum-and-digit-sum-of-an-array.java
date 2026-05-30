class Solution {
    public int differenceOfSum(int[] nums) {
        int sum =0;
        for(int i =0 ; i < nums.length ; i++){
            sum+=nums[i];
        }
        int digitsum =0 ;
        
       for(int i =0 ; i < nums.length ;i++){
        int temp = nums[i];
        while(temp!=0){
            digitsum+=temp%10;
            temp=temp/10;
        }

       }
       return Math.abs(sum-digitsum);
    }
}