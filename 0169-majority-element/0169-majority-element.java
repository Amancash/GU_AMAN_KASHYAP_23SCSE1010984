class Solution {
    public int majorityElement(int[] nums) {
        int counter=1;
        int majority=nums[0];
        int i =1;
        while(i<nums.length){
            if(majority==nums[i]){
                counter=counter+1;
                // majority=nums[i];
                i++;

            }else{
                counter=counter-1;
                if(counter==0){
                    majority=nums[i];
                    counter = 1;
                }
                i++;
            }
        }
        return majority;
    }
}
