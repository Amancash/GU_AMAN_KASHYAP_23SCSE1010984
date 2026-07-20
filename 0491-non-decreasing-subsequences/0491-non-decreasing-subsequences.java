class Solution {
    int n;
    public List<List<Integer>> findSubsequences(int[] nums) {
        n= nums.length;
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        backtrack(result , curr, 0 , nums);
        return result;
    }
    public void backtrack(List<List<Integer>> result, List<Integer> curr, int idx ,int[] nums){
        if(curr.size() >=2 ){
            result.add(new ArrayList<>(curr));
        }

        List<Integer> st = new ArrayList<>();
        for(int i =idx ; i<n ; i++){
            if((curr.isEmpty() || nums[i] >= curr.get(curr.size() - 1)) &&(!st.contains(nums[i]))){
                curr.add(nums[i]);
                backtrack(result , curr , i+1 , nums);
                curr.remove(curr.size() - 1);

                st.add(nums[i]);
            }

        }
    }
}