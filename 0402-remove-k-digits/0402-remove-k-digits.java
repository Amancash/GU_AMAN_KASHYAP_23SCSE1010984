class Solution {
    public String removeKdigits(String s, int k) {
        Stack<Integer> stack = new Stack<>();

        int i = 0;
        while (i < s.length()) {
            while (!stack.isEmpty() &&
       stack.peek() > Character.getNumericValue(s.charAt(i)) &&
       k > 0) {
                stack.pop();
                k--;
            }

            stack.push(Character.getNumericValue(s.charAt(i)));
            i++;

        }
        while (k > 0) {
            stack.pop();
            k--;
        }
        StringBuilder ans = new StringBuilder();

        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }

        ans.reverse();
        while (ans.length() > 0 && ans.charAt(0) == '0') {
            ans.deleteCharAt(0);
        }
        if(ans.isEmpty()) return "0";
        return ans.toString();

    }
}