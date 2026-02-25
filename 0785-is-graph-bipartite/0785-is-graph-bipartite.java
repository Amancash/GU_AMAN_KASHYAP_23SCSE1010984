class Solution {
    public boolean isBipartite(int[][] graph) {

        int n = graph.length;
        int[] vis = new int[n];  
        Arrays.fill(vis, -1);

        for (int start = 0; start < n; start++) {
            if (vis[start] == -1) { 
                Queue<Integer> q = new LinkedList<>();
                q.offer(start);
                vis[start] = 0;

                while (!q.isEmpty()) {
                    int node = q.poll();

                    for (int nei : graph[node]) {
                        if (vis[nei] == -1) {
                            vis[nei] = 1 - vis[node];
                            q.offer(nei);
                        } 
                        else if (vis[nei] == vis[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}