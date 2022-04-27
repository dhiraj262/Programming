class Solution {
    
    final static int N = 100001;
    boolean[] visited = new boolean[N];
    List<Integer>[] adj = new ArrayList[N];
    
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        
        for(int i=0;i<s.length();i++){
            adj[i] = new ArrayList<Integer>();
            
        }
        
        for(List<Integer> edge:pairs){
            adj[edge.get(0)].add(edge.get(1));
            adj[edge.get(1)].add(edge.get(0));
        }
        
        char[] ans = new char[s.length()];
        for(int vertex=0;vertex<s.length();vertex++){
            if(!visited[vertex]) {
                List<Character> characters = new ArrayList<>();
                List<Integer> indices = new ArrayList<>();
                dfs(s, vertex, characters, indices);
                // Sort the list of characters and indices
                Collections.sort(characters);
                Collections.sort(indices);
                
                for (int i = 0; i < characters.size(); i++) {
                    ans[indices.get(i)] = characters.get(i);
                }
            }
        }
        return new String(ans);
    }
    
    private void dfs(String s, int vertex, List<Character> characters, List<Integer> indices){
        
        characters.add(s.charAt(vertex));
        indices.add(vertex);
        visited[vertex] = true;
        // Traverse the adjacents
        for (int adjacent : adj[vertex]) {
            if (!visited[adjacent]) {
                dfs(s, adjacent, characters, indices);
            }
        }
    }
}