class Solution {
    public String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();
        Stack<String> stack = new Stack<>();

        int n = path.length();
        int i = 0;

        while (i < n) {
            while (i < n && path.charAt(i) == '/') {
                i++;
            }

            if (i >= n)
                break;

            StringBuilder token = new StringBuilder();
            while (i < n && path.charAt(i) != '/') {
                token.append(path.charAt(i));
                i++;
            }

            String part = token.toString();
            if (part.equals(".")) {
                continue;
            }

            if (part.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(part);
        }
        if (!stack.isEmpty() && stack.peek() == "/")
            stack.pop();

        for (String x : stack) {
            sb.append("/").append(x);
        }

        return sb.length() == 0 ? "/" : sb.toString();
    }
}
