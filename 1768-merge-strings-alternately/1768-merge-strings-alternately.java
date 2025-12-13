class Solution {
    public String mergeAlternately(String word1, String word2) {
        String word="";
        int size =word1.length()+word2.length();
        int i =0;
        while(i < word1.length() && i< word2.length()){
            word+=word1.charAt(i);
            word+=word2.charAt(i);
            i++;
        }
        while(i < word1.length() ){
            word+=word1.charAt(i);
            i++;
        }
        while(i< word2.length()){
            word+=word2.charAt(i);
            i++;
        }
        return word;
        
    }
}