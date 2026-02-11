class Solution {
    int[][] dp;

    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();

        dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dp[i][j] = -1;
            }
        }

        return solve(s, p, n - 1, m - 1);
    }

    public boolean solve(String s, String p, int i, int j) {
        if (i < 0 && j < 0)
            return true;

        if (j < 0 && i >= 0)
            return false;

        if (i < 0 && j >= 0) {
            for (int k = 0; k <= j; k++) {
                if (p.charAt(k) != '*')
                    return false;
            }
            return true;
        }

        if (dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean ans;

        if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?') {
            ans = solve(s, p, i - 1, j - 1);
        }
        else if (p.charAt(j) == '*') {
            ans = solve(s, p, i, j - 1) || solve(s, p, i - 1, j);
        }
        else {
            ans = false;
        }

        dp[i][j] = ans ? 1 : 0;   // store result
        return ans;
    }
}
