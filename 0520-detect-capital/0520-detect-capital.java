class Solution {
    public boolean detectCapitalUse(String word) {
        boolean case1=cap(word);
        boolean case2=sma(word);
        boolean case3=mix(word);
        return (case1 || case2 || case3);
        

    }
    public boolean cap(String n){
        n = n.trim();
        for(int i =0 ; i<n.length();i++){
            if(!Character.isUpperCase(n.charAt(i))){
                return false;
            }

        }
        return true;
    }
    public boolean sma(String n){
        n = n.trim();
        for(int i =0 ; i<n.length();i++){
            if(Character.isUpperCase(n.charAt(i))){
                return false;
            }

        }
        return true;
    }
    public boolean mix(String n){
        n = n.trim();
        if(!Character.isUpperCase(n.charAt(0))){
            return false;
        
        }
        for(int i =1 ; i<n.length();i++){
                if(Character.isUpperCase(n.charAt(i))){
                    return false;
                }

            }
        return true;
    }
}