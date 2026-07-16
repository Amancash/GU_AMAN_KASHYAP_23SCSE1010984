class Solution {
    public String removeKdigits(String num, int k) {

        StringBuilder sb = new StringBuilder();

        for (char ch : num.toCharArray()) {

            while (sb.length() > 0 &&
                   k > 0 &&
                   sb.charAt(sb.length() - 1) > ch) {

                sb.deleteCharAt(sb.length() - 1);
                k--;
            }

            sb.append(ch);
        }

        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }

        int i = 0;
        while (i < sb.length() && sb.charAt(i) == '0') {
            i++;
        }

        String ans = sb.substring(i);

        return ans.isEmpty() ? "0" : ans;
    }
}
