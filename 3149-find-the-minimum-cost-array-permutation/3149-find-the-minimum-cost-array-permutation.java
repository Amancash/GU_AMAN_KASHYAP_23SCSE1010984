import java.util.Arrays;

class Solution {
    private int n;
    private int[][] memo;
    private int[] nums;

    public int[] findPermutation(int[] nums) {
        this.n = nums.length;
        this.nums = nums;
        
        // memo[mask][pre] stores the minimum cost from a given bitmask state with 'pre' as the last element.
        // There are 1 << n masks and n possible previous indices.
        this.memo = new int[1 << n][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // Always start with 0 for lexicographically smallest permutation
        int bestCost = dfs(1, 0); 
        
        // Reconstruct the optimal path
        int[] result = new int[n];
        int mask = 1;
        int pre = 0;
        result[0] = 0;
        
        for (int i = 1; i < n; i++) {
            for (int cur = 1; cur < n; cur++) {
                if ((mask & (1 << cur)) == 0) {
                    int subCost = Math.abs(pre - nums[cur]) + dfs(mask | (1 << cur), cur);
                    if (subCost == memo[mask][pre]) {
                        result[i] = cur;
                        mask |= (1 << cur);
                        pre = cur;
                        break;
                    }
                }
            }
        }
        
        return result;
    }

    private int dfs(int mask, int pre) {
        if (mask == (1 << n) - 1) {
            return Math.abs(pre - nums[0]); // Close the cycle back to 0
        }
        if (memo[mask][pre] != -1) {
            return memo[mask][pre];
        }

        int minCost = Integer.MAX_VALUE;
        for (int cur = 1; cur < n; cur++) {
            if ((mask & (1 << cur)) == 0) {
                int cost = Math.abs(pre - nums[cur]) + dfs(mask | (1 << cur), cur);
                minCost = Math.min(minCost, cost);
            }
        }

        return memo[mask][pre] = minCost;
    }
}