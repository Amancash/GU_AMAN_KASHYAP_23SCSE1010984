class Solution {
    int[][] dp;
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        dp = new int[n][m];
        for(int i =0 ; i<n ; i++){
            for(int j =0 ;j<m ;j++){
                dp[i][j]=-1;
            }
        }
       return solve (word1 ,word2 ,word1.length()-1,word2.length()-1);
    }
    public int solve(String s, String t , int i ,int j){
        if(i < 0) return j + 1;   // insert all remaining of t
        if(j < 0) return i + 1;   // delete all remaining of s
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j]= 0+solve(s,t,i-1,j-1);
        }
        else return dp[i][j]= Math.min(1+solve(s,t,i,j-1),Math.min(1+solve(s,t,i-1,j),1+solve(s,t,i-1,j-1)));
    }
}