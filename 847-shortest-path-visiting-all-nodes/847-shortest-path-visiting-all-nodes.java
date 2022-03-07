class Solution {
    public int shortestPathLength(int[][] graph) {
        int ans = 0;
        if(graph.length <=1) return ans;
        
        int maskedBit = (1<<graph.length) - 1;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i< graph.length; i++)
            queue.add(new int[]{i, 1<<i});
        
        int[][] visited = new int[graph.length][maskedBit+1];
        
        while(!queue.isEmpty()){
            int size = queue.size();
            ans++;
            
            for (int i = 0; i<size; i++){
                int[] head = queue.poll();
                
                int u = head[0];
                int bitState = head[1];
                
                for (int v: graph[u]){
                    
                    int newBitState = bitState | (1<< v);
                    if (visited[v][newBitState] == 1)
                        continue;
                    if (newBitState == maskedBit)
                        return ans;
                    
                    visited[v][newBitState]=1;
                    queue.add(new int[]{v, newBitState});
                }
            }
        }
        return -1;   
    }
}