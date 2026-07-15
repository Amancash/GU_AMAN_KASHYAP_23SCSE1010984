class Solution {
    public boolean validateStackSequences(int[] in, int[] out) {
        Stack<Integer> s = new Stack<>();

int i = 0;
int j = 0;

while (i < in.length) {

    s.push(in[i]);

    while (!s.isEmpty() && j < out.length && s.peek() == out[j]) {
        s.pop();
        j++;
    }

    i++;
}

return s.isEmpty();
    }   
}