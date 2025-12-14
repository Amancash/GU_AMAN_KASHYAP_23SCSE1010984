class Solution {
    public String reverseVowels(String s) {
      List<Character> list = new ArrayList<>();
      String str="";
      for(int i =0 ;i<s.length() ; i++){
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
            list.add(s.charAt(i));
        }
      }
      Collections.reverse(list);
      int idx=0;
      for(int i =0 ;i<s.length() ; i++){
        if(s.charAt(i)=='a'||s.charAt(i)=='e'||s.charAt(i)=='i'||s.charAt(i)=='o'||s.charAt(i)=='u'||s.charAt(i)=='A'||s.charAt(i)=='E'||s.charAt(i)=='I'||s.charAt(i)=='O'||s.charAt(i)=='U'){
            str += list.get(idx++);
        }
        else{
            str+=s.charAt(i);
        }
    }

    return str;
    }
}