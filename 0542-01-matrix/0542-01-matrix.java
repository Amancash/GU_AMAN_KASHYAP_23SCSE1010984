class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] vis = new int[n][m];
        int[][] distarr = new int[n][m];
        Queue<int[]> q = new LinkedList<>();
        for(int i =0 ; i<n ;i++){
            for(int j =0 ; j<m ;j++){
                if(mat[i][j]==0){
                    q.offer(new int[]{i,j,0});
                    vis[i][j]=1;
                }
            }
        }
        int[] drow = {-1,0,1,0};
        int[] dcol = {0,1,0,-1};
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int row= curr[0];
            int col = curr[1];
            int dist = curr[2];
            distarr[row][col]=dist;
            for(int i =0 ; i <4 ; i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1){
                    vis[nrow][ncol]=1;
                    q.offer(new int[]{nrow,ncol,dist+1});
                }
            }
        }
        return distarr;
    }
}