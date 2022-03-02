class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        //starting from 0
        dfs(0,graph, result,path);
        
        return result;
    }
    
    private void dfs(int node,int[][] graph,List<List<Integer>> result ,List<Integer> path){
        
        
        // adding first to the path
        path.add(node);
        
        //if at the target
        if(node == graph.length-1){
            result.add(new ArrayList<>(path));
        } else {
            //checking for other paths
            for(int i=0;i<graph[node].length;i++){
                
                dfs(graph[node][i],graph,result,path);
            }
        }
        
        //removing the last node to backtrak and check other path after reaching to the path
        path.remove(path.size()-1);
        
    }
}