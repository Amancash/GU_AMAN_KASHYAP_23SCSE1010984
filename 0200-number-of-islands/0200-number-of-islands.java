// class Solution {
//     boolean[][] vis;
//     public int numIslands(char[][] grid) {
//         int n = grid.length;
//         int m = grid[0].length;
//         vis = new boolean[n][m];
//         int count=0;
//         for(int i =0 ; i <n ; i ++){
//             for(int j =0 ; j <m ; j ++){
//                 if(grid[i][j] == '1' && !vis[i][j]){
//                     count++;
//                     dfs(i,j,grid);
//                 }
//         } 
//         }
//         return count;

//     }
//     public void dfs(int i , int j ,char[][] grid){
//         int n = grid.length;
//         int m = grid[0].length;
//         if (i < 0 || j < 0 || i >= n || j >= m) return;
//         if (grid[i][j] == '0' || vis[i][j]) return;
//         vis[i][j]=true;
//         dfs(i + 1, j, grid);
//         dfs(i - 1, j, grid);
//         dfs(i, j + 1, grid);
//         dfs(i, j - 1, grid);
//     }
// }

class Solution {
    int n, m;

    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int count = 0;

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1') {
                    count++;

                    q.offer(new int[]{i, j});
                    grid[i][j] = '0'; // mark visited

                    while (!q.isEmpty()) {
                        int[] cur = q.poll();
                        int x = cur[0];
                        int y = cur[1];

                        // down
                        if (x + 1 < n && grid[x + 1][y] == '1') {
                            grid[x + 1][y] = '0';
                            q.offer(new int[]{x + 1, y});
                        }
                        // up
                        if (x - 1 >= 0 && grid[x - 1][y] == '1') {
                            grid[x - 1][y] = '0';
                            q.offer(new int[]{x - 1, y});
                        }
                        // right
                        if (y + 1 < m && grid[x][y + 1] == '1') {
                            grid[x][y + 1] = '0';
                            q.offer(new int[]{x, y + 1});
                        }
                        // left
                        if (y - 1 >= 0 && grid[x][y - 1] == '1') {
                            grid[x][y - 1] = '0';
                            q.offer(new int[]{x, y - 1});
                        }
                    }
                }
            }
        }
        return count;
    }
}
