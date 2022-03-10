class Solution {
    public boolean isBipartite(int[][] graph) {
        
        // BFS 
        int[] colors = new int[graph.length];
        
        for (int i = 0; i < graph.length; i++)
            if (colors[i] == 0) {
                Queue<Integer> q = new LinkedList<>();
                q.add(i);
                colors[i] = 1;
                while (!q.isEmpty()) {
                    int u = q.poll();
                    for (int v : graph[u])
                        if (colors[v] == colors[u])
                            return false;
                        else if (colors[v] == 0) {
                            q.add(v);
                            colors[v] = -colors[u];
                        }
                }
            }
        return true;
    }
}