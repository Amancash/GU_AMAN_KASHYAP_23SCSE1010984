class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> list = new ArrayList<>();
        Boolean[] list2 = new Boolean[candies.length];
        for(int i =0 ; i<candies.length ; i++){
            int temp = candies[i]+extraCandies;
            for(int j =0 ; j<candies.length ;j++){
                if(temp<candies[j]){
                    list2[i] = false;
                    break;
                }
                list2[i] = true;
                
            }
           
        
        }
        list = new ArrayList<>(Arrays.asList(list2));
        return list;
    }
}