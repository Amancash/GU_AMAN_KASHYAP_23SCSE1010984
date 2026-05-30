class Solution {
    public int countKeyChanges(String s) {
        int count=0;
        for(int i =0 ; i< s.length()-1 ; i++){
            char temp1 = Character.toLowerCase(s.charAt(i));
            char temp2 = Character.toLowerCase(s.charAt(i+1));
            if(temp1 != temp2){
                count++;
            }
        }
        return count;
    }
}