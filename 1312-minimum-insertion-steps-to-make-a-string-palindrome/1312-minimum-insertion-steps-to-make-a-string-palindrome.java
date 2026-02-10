class Solution {
    int[][] dp;
    public int minInsertions(String s) {
        dp = new int[s.length()][s.length()];
        for(int i =0 ; i < s.length() ; i++){
            for(int j =0 ;j<s.length() ; j++){
                dp[i][j]=-1;
            }
        }
        return s.length()-solve(s, new StringBuilder(s).reverse().toString(),s.length()-1,s.length()-1);
    }
    public int solve(String s1 , String s2 , int i ,int j){
        if(i<0 || j<0) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        if(s1.charAt(i)==s2.charAt(j)) return dp[i][j]=1 + solve(s1,s2,i-1,j-1);
        return dp[i][j]= 0+ Math.max(solve(s1,s2,i,j-1),solve(s1,s2,i-1,j));
    }

}
