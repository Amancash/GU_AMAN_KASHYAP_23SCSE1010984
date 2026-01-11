class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list =new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(0,list,temp,nums,nums.length);
        return list;
    }
    public void solve(int i ,List<List<Integer>> list , List<Integer> temp,int[] nums, int n){
        if(i>=n){
            list.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        solve(i+1,list,temp,nums,n);
        temp.remove(temp.size()-1);
        solve(i+1,list,temp,nums,n);
    }
    
}