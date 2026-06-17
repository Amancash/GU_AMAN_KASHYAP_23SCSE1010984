import java.util.*;

class Solution {
    public char processStr(String s, long k) {

        int n = s.length();
        long[] len = new long[n + 1];

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);

            if (ch >= 'a' && ch <= 'z') {
                len[i + 1] = len[i] + 1;
            } else if (ch == '*') {
                len[i + 1] = Math.max(0, len[i] - 1);
            } else if (ch == '#') {
                len[i + 1] = Math.min((long) 1e18, len[i] * 2);
            } else { // %
                len[i + 1] = len[i];
            }
        }

        if (k >= len[n]) return '.';

        long idx = k;

        for (int i = n - 1; i >= 0; i--) {

            char ch = s.charAt(i);
            long prevLen = len[i];
            long curLen = len[i + 1];

            if (ch >= 'a' && ch <= 'z') {

                if (idx == curLen - 1) {
                    return ch;
                }

            } else if (ch == '*') {

                // after deletion length decreased by 1
                // surviving indices stay unchanged

            } else if (ch == '#') {

                long half = prevLen;

                if (idx >= half) {
                    idx -= half;
                }

            } else { // %

                idx = curLen - 1 - idx;
            }
        }

        return '.';
    }
}