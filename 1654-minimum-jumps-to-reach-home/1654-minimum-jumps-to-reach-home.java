class Solution {
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        int steps = 0, lastPos = x + a + b;
        Queue<Pair<Integer, Integer>> queue = new LinkedList();
        
        queue.offer(new Pair(0, 0)); // direction & position;
        
        Set<Pair<Integer, Integer>> visited = new HashSet<>(queue);
        for (int pos : forbidden) {
            visited.add(new Pair(0, pos));
            visited.add(new Pair(1, pos));
            lastPos = Math.max(lastPos, pos + a + b);
        }
        while (!queue.isEmpty()) {
            for (int s = queue.size(); s > 0; --s) {
                
                Pair<Integer, Integer> p = queue.poll();
                
                int dir = p.getKey(), pos = p.getValue();
                
                if (pos == x) {
                    return steps;
                }
                Pair<Integer, Integer> forward = new Pair<>(0, pos + a), backward = new Pair<>(1, pos - b);
                if (pos + a <= lastPos && visited.add(forward)) {
                    queue.offer(forward);
                }
                if (dir == 0 && pos - b >= 0 && visited.add(backward)) {
                    queue.offer(backward);
                }
            }
            ++steps;
        }
        return -1;       
    }
}