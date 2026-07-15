class Solution {
    public String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        int i =1;
        stack.push(s.charAt(0));
        while(i<s.length()){
            if(s.charAt(i)!='*'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i)=='*'){
                stack.pop();
            }
            i++;

        }
        StringBuilder ans = new StringBuilder();
        while(!stack.isEmpty()){
            ans.append(stack.pop());
        }
        return ans.reverse().toString();
    }
}