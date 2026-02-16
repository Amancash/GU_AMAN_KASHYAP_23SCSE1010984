class Solution {
    boolean[] vis;
    public int findCircleNum(int[][] isConnected) {
        vis = new boolean[isConnected.length];
        int count=0;
        for(int i=0 ;i<isConnected.length ; i++){
            if(vis[i]==false){
                count++;
                dfs(i,isConnected);
            }
        }
        return count;
    }
    public void dfs(int node, int[][] isConnected) {
        vis[node] = true;

        for (int j = 0; j < isConnected.length; j++) {
            if (isConnected[node][j] == 1 && !vis[j]) {
                dfs(j, isConnected);
            }
        }
    }
}