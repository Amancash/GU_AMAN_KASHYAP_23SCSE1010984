class Solution {
    Set<String> result;
    boolean[] used;
    public int numTilePossibilities(String tiles) {
        result = new HashSet<>();
        used = new boolean[tiles.length()];
        String curr="";
        solve(tiles,used,result,curr);
        return result.size()-1;
    }
    public void solve(String t,boolean[] used,Set<String> result,String curr) {

    result.add(curr);

    for (int idx =0; idx <t.length();idx++) {

        if (used[idx]) continue;
        used[idx] = true;

        solve(t,used,result, curr +t.charAt(idx));
        used[idx]=false;
    }
}
}