class Solution {
    public int openLock(String[] deadends, String target) {
        if("0000".equals(target)) return 0;
        
        HashSet<String> set = new HashSet<>(Arrays.asList(deadends));
        if (set.contains("0000")) return -1;
        
        int steps=0;
        Queue<String> queue = new LinkedList<>();
        queue.add("0000");
        Set<String> seen = new HashSet<>();
        seen.add("0000");
        
        while(!queue.isEmpty()){
             steps++;
            int size = queue.size();
            while(size-->0){
                String curr = queue.poll();
                for (int i = 0; i < curr.length(); i++){
                    
                    for (int dif = 1; dif <= 9; dif += 8) {
                        char[] ca = curr.toCharArray();
                        ca[i] = (char)((ca[i] - '0' + dif) % 10 + '0');
                        String s = new String(ca);
                        if (target.equals(s)) return steps;
                        if (!set.contains(s) && !seen.contains(s)) queue.add(s);
                        seen.add(s);
                    }
                }
            }
           
         }
         return -1;
    }
}