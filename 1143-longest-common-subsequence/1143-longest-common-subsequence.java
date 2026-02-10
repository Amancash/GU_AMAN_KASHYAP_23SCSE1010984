// class Solution {
//     int[][] dp;
//     public int longestCommonSubsequence(String text1, String text2) {
//         dp=new int[text1.length()+1][text2.length()+1];

//         for(int i =0 ; i<text1.length()+1){
//             dp[i][0]=0;
//         }
//         for(int i =0 i < text2.length()+1;i++){
//             dp[0][i]=0;
//         }
//         for(int i =1 ;i<text1.length()+1;i++){
//             for(int j=1 ;j<text2.length()+1;j++){
//                 if(text1.charAt(i-1)==text2.charAt(j-1)){
//                     dp[i][j]=1+dp[i-1][j-1]
//                 }
//             }
//         }
//        return solve(text1,text2,text1.length(),text2.length());
//     }
//     public int solve(String text1,String text2, int i,int j){
//         if(i==0 || j==0){
//             return 0;
//         }
//         if(dp[i][j] !=-1){
//             return dp[i][j];
//         }
//         if(text1.charAt(i-1)==text2.charAt(j-1)){
//             return dp[i][j]=1 + solve(text1, text2, i-1, j-1);
//         }else{
//             return dp[i][j]=Math.max(solve(text1, text2, i-1, j),solve(text1, text2, i, j-1));
//         }
//     }
// }

// class Solution {
//     int[][] dp;
//     public int longestCommonSubsequence(String text1, String text2) {
//         dp = new int[text1.length()][text2.length()];
//         for(int i =0 ; i<text1.length();i++){
//             for( int j=0 ;j<text2.length();j++){
//                 dp[i][j]=-1;
//             }
//         }
//         return solve(text1,text2,text1.length()-1,text2.length()-1);
//     }
//     public int solve(String s1,String s2,int i1,int i2){
//         if(i1<0 || i2<0) return 0;
//         if(dp[i1][i2]!=-1) return dp[i1][i2];
//         if(s1.charAt(i1)==s2.charAt(i2)) return dp[i1][i2]= 1+solve(s1,s2,i1-1,i2-1);
//         return dp[i1][i2]=0+Math.max(solve(s1,s2,i1,i2-1),solve(s1,s2,i1-1,i2));
//     }
// }

// class Solution {
    
//     public int longestCommonSubsequence(String text1, String text2) {
//         return solve(text1,text2,text1.length(),text2.length());
//     }
//     public int solve(String s1,String s2,int i1,int i2){
//         if(i1==0 || i2==0) return 0;
//         if(s1.charAt(i1-1)==s2.charAt(i2-1)) return 1+solve(s1,s2,i1-1,i2-1);
//         return 0+Math.max(solve(s1,s2,i1,i2-1),solve(s1,s2,i1-1,i2));
//     }
// }

class Solution {
    int[][] dp;
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        dp = new int[text1.length()+1][text2.length()+1];
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= m; j++){
                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];


        // return solve(text1,text2,text1.length()-1,text2.length()-1);
    }
    public int solve(String s1,String s2,int i1,int i2){
        if(i1<0 || i2<0) return 0;
        if(dp[i1][i2]!=-1) return dp[i1][i2];
        if(s1.charAt(i1)==s2.charAt(i2)) return dp[i1][i2]= 1+solve(s1,s2,i1-1,i2-1);
        return dp[i1][i2]=0+Math.max(solve(s1,s2,i1,i2-1),solve(s1,s2,i1-1,i2));
    }
}