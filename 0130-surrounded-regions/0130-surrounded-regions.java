class Solution {
    int n;
    int m;
    int[][] vis;
    int[] drow ={-1,0,1,0};
    int[] dcol = {0,-1,0,1};
    public void solve(char[][] board) {
        n = board.length;
        m = board[0].length;
        vis = new int[n][m];

        for(int j = 0 ; j<m; j++) {
            if(vis[0][j] !=1 && board[0][j] == 'O') dfs(0, j, board);
            
            if(vis[n-1][j] !=1 && board[n-1][j] == 'O') dfs(n-1,j,board);

        }
        
        for(int i = 0;i<n; i++) {

            if(vis[i][0]!=1 && board[i][0] == 'O') dfs(i, 0, board);

            if(vis[i][m-1]!=1 && board[i][m-1] == 'O') dfs(i, m-1, board);
        }
        for(int i = 0;i<n; i++) {
            for(int j= 0 ;j<m; j++) {
                if(vis[i][j]==0 && board[i][j] == 'O')
                board[i][j] = 'X';
            }
        }
    }
    public void dfs(int row ,int col , char[][] board){
        vis[row][col]=1;
        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + drow[i];
            int ncol = col + dcol[i];
            if(nrow >= 0 && nrow<n && ncol>=0 && ncol < m && vis[nrow][ncol] !=1 && board[nrow][ncol]=='O'){
                dfs(nrow,ncol,board);
            } 
        }
    }
}