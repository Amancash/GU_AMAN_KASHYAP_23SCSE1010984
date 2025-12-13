class Solution {
    public boolean canPlaceFlowers(int[] arr, int n) {
        int i=0;
        if(arr.length==1){
            if(arr[i]==0 && (n==1 || n==0)){
                return true;
            }
        }
        if(arr[i]==0){
            if(arr[i+1]==0){
                arr[i]=1;
                n=n-1;
                i++;
            }
        }
        for(i=1;i<arr.length-1;i++){
            if(arr[i]==0){
                if(arr[i-1]==0 && arr[i+1]==0){
                    arr[i]=1;
                    n=n-1;
                }
            }
        }
        if(arr[arr.length-1]==0){
            if(arr[i-1]==0){
                arr[i]=1;
                n=n-1;
                i++;
                
            }
        }

        if(n<=0){
            return true;
        }else{
            return false;
        }

    }
}