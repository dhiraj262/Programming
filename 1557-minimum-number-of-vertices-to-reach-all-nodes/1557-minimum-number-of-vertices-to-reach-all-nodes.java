class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        int[] vertices = new int[n+1];
        List<Integer> ans = new ArrayList<>();
        for(int i=0;i<edges.size();i++){
          
            vertices[edges.get(i).get(1)] ++; // edges where there is indegree
        }
        
        for(int i=0;i<n;i++){
            
            if(vertices[i] == 0 ) ans.add(i);
        }
        
        return ans;
    }
}