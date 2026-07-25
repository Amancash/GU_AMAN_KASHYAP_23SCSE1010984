class Solution {
    List<List<Integer>> list;
    List<Integer> curr;
    int n;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        n = candidates.length;
        list = new ArrayList<>();
        curr = new ArrayList<>();
         Arrays.sort(candidates);
         solve(0,candidates,target);
        return list;
        
    }
    public void solve(int i ,int[] candidates,int target){
        if(target <0){
            return;
        }
        
        if(target ==0){
            list.add(new ArrayList(curr));
            return;
        }
        for(int idx =i ; idx < n ; idx++){
            if(idx > i && candidates[idx]==candidates[idx-1]){
                continue;
            }
        curr.add(candidates[idx]);
        solve(idx+1, candidates , target-candidates[idx]);
        curr.remove(curr.size()-1);

        }
        
    }
}