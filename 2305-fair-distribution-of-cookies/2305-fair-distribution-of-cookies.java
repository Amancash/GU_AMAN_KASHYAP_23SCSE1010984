class Solution {

    int result = Integer.MAX_VALUE;
    int n;

    public int distributeCookies(int[] cookies, int k) {
        n = cookies.length;
        int[] children = new int[k];

        solve(0, cookies, children, k);

        return result;
    }

    public void solve(int idx, int[] cookies, int[] children, int k) {

        if (idx == n) {

            int unfairness = 0;
            for (int child : children) {
                unfairness = Math.max(unfairness, child);
            }

            result = Math.min(result, unfairness);
            return;
        }

        int cookie = cookies[idx];

        for (int i = 0; i < k; i++) {

            children[i] += cookie;

            solve(idx + 1, cookies, children, k);

            children[i] -= cookie;
        }
    }
}