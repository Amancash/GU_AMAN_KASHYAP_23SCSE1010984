class Solution {
    public int findMaxConsecutiveOnes(int[] arr) {
        int count =0;
        int ans =0;
        // int[] arr = {1,1,1,1,1,1,0,1,1,1,1,0,1};
        for(int i =0 ; i < arr.length ; i++){
            if(arr[i]==1){
                count++;
                ans = Math.max(ans,count);
            }
            if(arr[i]==0){
                ans = Math.max(ans,count);
                count =0;
            }
        }
        return ans;
    }
}
