class Solution {
    public int[] topKFrequent(int[] nums, int k) {
    
        if (k == nums.length) {
            return nums;
        }
        
        // 1. build hash map : character and how often it appears
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int n: nums) {
          freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // init heap 'the less frequent element first'
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(
            (n1, n2) -> freq.get(n1) - freq.get(n2));

        // 2. keep k top frequent elements in the heap
        // O(N log k) < O(N log N) time
        for (int n: freq.keySet()) {
          pQueue.add(n);
          if (pQueue.size() > k) pQueue.poll();    
        }

        // 3. build an output array
        // O(k log k) time
        int[] top = new int[k];
        for(int i = k - 1; i >= 0; --i) {
            top[i] = pQueue.poll();
        }
        return top;
    }
}
