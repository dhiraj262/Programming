class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(beginWord.equals(endWord)) return 0;
        
        HashSet<String> wordSet = new HashSet<>(wordList);
        if(!wordSet.contains(endWord)) return 0;
        int steps=0;
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        
        while(!queue.isEmpty()){
             steps++;
            int size = queue.size();
            if(queue.contains(endWord)) return steps;
            
            while(size-->0){
                String curr = queue.poll();
                StringBuilder sb = new StringBuilder(curr);
                for (int i = 0; i < curr.length(); i++){
                    
                    for (char j = 'a'; j <= 'z'; j++) {
                        sb.setCharAt(i, j);
                        if (wordSet.contains(sb.toString())) {
                            queue.offer(sb.toString());
                            wordSet.remove(sb.toString()); //remove for not creating duplicate results
                        }
                    }
                    sb.setCharAt(i, curr.charAt(i));
                }
            }
           
         }
         return 0;
    }
}