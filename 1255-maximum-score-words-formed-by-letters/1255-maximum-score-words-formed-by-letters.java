class Solution {
    int maxScore =0;
    int n;

    public int maxScoreWords(String[] words,char[] letters,int[] score) {
        n =words.length;

        int[] freq = new int[26];
        for (char ch :letters) {
            freq[ch -'a']++;
        }

        solve(0,score,words, 0,freq);

        return maxScore;
    }

    private void solve(int i, int[] score, String[] words, int currScore,int[] freq) {

        if (i >= n) {
            maxScore = Math.max(maxScore, currScore);
            return;
        }
        solve(i + 1, score, words, currScore, freq);


        int[] tempFreq = freq.clone();
        int tempScore = 0;
        boolean canTake = true;

        for (int j = 0; j < words[i].length(); j++) {
            char ch = words[i].charAt(j);

            tempFreq[ch - 'a']--;
            tempScore += score[ch - 'a'];

            if (tempFreq[ch - 'a'] < 0) {
                canTake = false;
                break;
            }
        }if (canTake) {
            solve(i + 1, score, words, currScore + tempScore, tempFreq);
        }
    }
}