
class Solution {
    public int removeElement(int[] nums, int val) {
        int index =0;
        for(int x : nums){
            if(x != val){
                nums[index++]=x;
            }
        }
        return index;


        // int size =0;
        // for(int i = 0 ; i<nums.length;i++){
        //     if(nums[i] != val){
        //         nums[size]=nums[i];
        //         size++;
        //     }

        // }
        // return size;
    }
}