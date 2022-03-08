class Solution {
    public int minMutation(String start, String end, String[] bank) {
        
        if(start.equals(end)) return 0;
        
        HashSet<String> set = new HashSet<>(Arrays.asList(bank));
        char[] charSet = new char[]{'A', 'C', 'G', 'T'};
        
        int steps=0;
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        Set<String> seen = new HashSet<>();
        seen.add(start);
        
        while(!queue.isEmpty()){
            
            int s = queue.size();
            while(s-->0){
                String curr = queue.poll();
                
                if(curr.equals(end)) return steps;
                
                char[] currArray = curr.toCharArray();
                for(int i=0;i<currArray.length;i++){
                    char temp = currArray[i];
                    for(char c:charSet){
                        currArray[i] = c;
                        String nextStr = new String(currArray);
                        
                        if(!seen.contains(nextStr) && set.contains(nextStr)) {
                            seen.add(nextStr);
                            queue.offer(nextStr);
                        }
                    }
                    currArray[i] = temp;
                }
            }
            steps++;
         }
         return -1;
    }
}