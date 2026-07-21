class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start ^ goal;
        int distance = 0;
        while (xor != 0) {
            xor &= (xor - 1);
            distance++;
        }
        
        return distance;
    }
}