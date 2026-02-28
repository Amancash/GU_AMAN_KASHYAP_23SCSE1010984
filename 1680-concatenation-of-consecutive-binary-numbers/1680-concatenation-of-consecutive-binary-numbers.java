class Solution {
    public int concatenatedBinary(int n) {
        int MOD = 1_000_000_007;
        long ans = 0;
        int bits = 0;

        for (int i = 1; i <= n; i++) {
            // if i is power of 2, bits increase
            if ((i & (i - 1)) == 0) {
                bits++;
            }

            ans = ((ans << bits) % MOD + i) % MOD;
        }

        return (int) ans;
    }
}