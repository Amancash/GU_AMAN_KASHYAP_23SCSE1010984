class Solution {
    int n ;
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        n = s.length();

        backtrack(result , curr , 0 , s);
        return result;
    }
    public void backtrack(List<List<String>> result, List<String> curr , int idx , String s){
        if (idx == n){
            result.add(new ArrayList<>(curr));
            return;
        }

        for(int i = idx ; i< n ; i++){
            if(palindrom(s,idx,i)){
                curr.add(s.substring(idx , i+1));
                backtrack(result,curr,i+1,s);
                curr.remove(curr.size() - 1);
            }
        }

    }
    public boolean palindrom(String s , int i , int idx){
        while(i<idx){
            if(s.charAt(i) != s.charAt(idx)){
                return false;
            }
            i++;
            idx--;
        }
        return true;
    }
}