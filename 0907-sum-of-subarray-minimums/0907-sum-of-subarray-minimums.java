import java.util.*;

class Solution {
    public int sumSubarrayMins(int[] arr) {

        int n = arr.length;
        int[] left = previousSmaller(arr);
        int[] right = nextSmaller(arr);

        long ans = 0;
        int MOD = 1000000007;

        for (int i = 0; i < n; i++) {

            long leftCount = i - left[i];
            long rightCount = right[i] - i;

            ans = (ans + (long) arr[i] * leftCount * rightCount) % MOD;
        }

        return (int) ans;
    }
    
    public int[] previousSmaller(int[] arr) {
        int n = arr.length;
        int[] left = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            stack.push(i);
        }

        return left;
    }

    public int[] nextSmaller(int[] arr) {
        int n = arr.length;
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            stack.push(i);
        }

        return right;
    }

    
}