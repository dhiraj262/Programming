class Solution {
    public int makeConnected(int n, int[][] connections) {
         if (connections.length < n-1)
            return -1;
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i=0; i<n; i++)
            adjList.add(new LinkedList<>());
        
        for (int [] connection : connections) {
            adjList.get(connection[0]).add(connection[1]);
            adjList.get(connection[1]).add(connection[0]);
        }
        
        boolean[] visited = new boolean[n];
        int comp = 0;
        for(int i=0;i<n;i++){
            if(visited[i] == false){
                dfs(i,adjList,visited);
                comp++;  // number of components
            }
        }
        
        int noEdges = connections.length -(n-1 -comp - 1);
        if(noEdges < comp-1){
            return -1;
        }
        return comp-1;
    }
    
    private void dfs(int u, List<List<Integer>> adj,boolean[] visited ){
        if(visited[u]==true) return;  // If already visited
        
        visited[u] = true;
        for(int v : adj.get(u)){
            if(visited[v] == false)
                dfs(v,adj,visited);
        }
        return;
    }
}