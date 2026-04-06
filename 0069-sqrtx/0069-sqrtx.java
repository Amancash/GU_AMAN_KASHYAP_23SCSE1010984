class Solution {
    public int mySqrt(int x) {
        if (x == 0 || x == 1) return x;

        int low = 1, high = x, ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // To avoid overflow, use long
            long square = (long) mid * mid;

            if (square == x) {
                return mid;
            } else if (square < x) {
                ans = mid;        // store possible answer
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}