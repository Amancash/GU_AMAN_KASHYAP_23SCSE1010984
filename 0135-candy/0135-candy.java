class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        int[] can = new int[n];
        Arrays.fill(can,1);
        // can[0] = ratings[0];
        for(int i =1 ; i< n ;i++){
            if(ratings[i-1] < ratings[i]){
                can[i] = can[i-1]+1;
            }
        }
        for(int i = n-2 ;i >= 0 ;i--){
            if(ratings[i+1] < ratings[i] && can[i+1] >= can[i]){
                can[i] = can[i+1]+1;
            }
        }
        int sum =0 ;
        for(int x :can){
            sum+=x;
        }
        return sum;
    }
}