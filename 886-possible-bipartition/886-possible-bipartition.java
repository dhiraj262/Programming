class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        
        List<Integer>[] adjList = new ArrayList[n+1];
        
        for(int i=1;i<=n;i++){
            adjList[i] = new ArrayList<>();
        }
        // creating the list
        for (int[] edge : dislikes) {
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }
        int[] colors = new int[n+1];
        
        for (int i = 1; i <= n; i++) {
            if (colors[i] == 0) {
                if (!dfs(i, adjList, colors, 1)) {
                    return false;
                }
            }
        }
        return true;
    }
    
    private boolean dfs(int u, List<Integer>[] adjList, int[] colors, int color){
        
        if (colors[u] != 0) {
            return colors[u] == color;
        }
        colors[u] = color;
        for (int v : adjList[u]) {
            if (!dfs(v, adjList, colors, -color)) {
                return false;
            }
        }
        return true;
    }
}