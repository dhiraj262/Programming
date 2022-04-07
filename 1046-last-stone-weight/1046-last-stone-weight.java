class Solution {
    public int lastStoneWeight(int[] stones) {
        
        if (stones == null || stones.length == 0) {
            return 0;
        }
        if (stones.length == 1) {
            return stones[0];
        }
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((num1, num2) -> Integer.compare(num2, num1));
        
        for (int stone : stones) {
            maxHeap.offer(stone);
        }
        while (maxHeap.size() >= 2) {
            int max1 = maxHeap.poll();
            int max2 = maxHeap.poll();
            
            if (max1 == max2) {
                continue;
            }
            
            max1 -= max2;
            maxHeap.offer(max1);
        }
        return maxHeap.isEmpty() ? 0 : maxHeap.poll();
    }
}