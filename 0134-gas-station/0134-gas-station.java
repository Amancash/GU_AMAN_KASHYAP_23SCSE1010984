class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tgas =0;
        int tcost =0;
        for(int x : gas){
            tgas +=x;
        }
        for(int x : cost){
            tcost += x;
        }

        if(tcost > tgas) return -1;
        // for(int i  =0 ; i< gas.length ;i++){
        //     int petrol =0;
        //     boolean flag = true;
        //     int j =0 ;
        //     for(j = i ; j< gas.length ;j++){
        //         petrol += gas[i];
        //         if(cost[i] >petrol ){
        //             flag = false ;
        //             i = j;
        //             break;
        //         }
        //         petrol -= gas[i];
                
        //     }
        // if(j==gas.length && flag){
        //     return i;
        // }
        // }
        // return -1;
        int post =0;
        int sum =0;
        for(int i =0 ; i< gas.length ;i++){
            sum += gas[i]-cost[i];
            if(sum < 0){
                sum =0;
                post =i+1;
            }
        }
        return post;
    }
}