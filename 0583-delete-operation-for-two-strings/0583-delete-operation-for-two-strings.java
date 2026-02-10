class Solution {
    int[][] dp;

    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for (int i = 0; i < word1.length(); i++) {
            for (int j = 0; j < word2.length(); j++) {
                dp[i][j] = -1;
            }
        }
        int lcs = solve(word1, word2, word1.length() - 1, word2.length() - 1);
        int ans = word1.length() + word2.length() - 2 * lcs;
        return ans;
    }

    public int solve(String s1, String s2, int i1, int i2) {
        if (i1 < 0 || i2 < 0)
            return 0;
        if(dp[i1][i2] != -1) return dp[i1][i2];
        if (s1.charAt(i1) == s2.charAt(i2))
            return dp[i1][i2]=1 + solve(s1, s2, i1 - 1, i2 - 1);
        return dp[i1][i2]= 0 + Math.max(solve(s1, s2, i1, i2 - 1), solve(s1, s2, i1 - 1, i2));
    }
}