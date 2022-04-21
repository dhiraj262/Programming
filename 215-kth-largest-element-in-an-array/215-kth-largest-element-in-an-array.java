class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> pq = new PriorityQueue<>();
        
        for (int n : nums) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}