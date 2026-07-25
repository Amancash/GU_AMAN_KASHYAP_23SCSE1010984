class Solution {
    int[] result;
    public int[] constructDistancedSequence(int n) {
        result = new int[2*n-1];
        for(int i =0 ; i< result.length ;i++){
            result[i]=-1;
        }
        boolean[] st = new boolean[n+1];
        solve(0,n,st);
        return result;
    }
    public boolean solve(int i , int n , boolean[] st){
        if(i>=result.length){
            return true;
        }
        if(result[i]!=-1){
            return solve(i+1,n,st);
        }


        for(int num = n ; num>=1 ;num--){
            if(st[num]){
                continue;
            }
            st[num] = true;
            result[i]=num;


            if(num==1){
                if(solve(i+1,n,st)==true){
                    return true;
                }
            }
            else{
                int j = result[i] +i;
                if((j<result.length)&& (result[j]==-1)){
                    result[j]=num;
                    if(solve(i+1,n,st)){
                        return true; 
                    }
                    result[j]=-1;
                }
            }
            st[num]=false;
            result[i]=-1;
        }
        return false;
    }
}