class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        // 0 : unvisited -white , 1 - gray -safe , 2-black-contains loop
        int[] color = new int[graph.length];
        
        for(int i = 0;i < graph.length;i++){
            if(dfs(graph, i, color) == false)    
                ans.add(i);
        }
        
        return ans;
    }
    private  boolean dfs(int[][] graph, int u, int[] color){
        
      color[u]= 1;
        
        for(int v : graph[u]){
            if(color[v]== 1) return true;
            else if (color[v]==0 && dfs(graph, v, color)) return true;
        }
        
        color[u]=2;
        return false;
    }
}