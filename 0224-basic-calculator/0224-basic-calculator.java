class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int number =0;
        int sign =1;
        int result =0;
        for(int i =0 ; i< s.length() ; i++){
            if (Character.isDigit(s.charAt(i))) {
                number = number*10 + (s.charAt(i)-'0');
            }else if(s.charAt(i)=='+'){
                result += sign * number;
                number =0;
                sign =1;
            }else if(s.charAt(i)=='-'){
                result += sign * number;
                number =0;
                sign =-1;
            }else if(s.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result=0;
                sign=1;
                number =0;
            }else if(s.charAt(i)==')'){
                result += sign*number;
                number =0;
                int stack_sign = stack.pop();
                int stack_last = stack.pop();

                result *=stack_sign;
                result += stack_last;

            }

        }
        result+=number*sign;
        return result;
    }
}