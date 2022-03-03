class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, curr = 0;
        for (int v: values) {
            ans = Math.max(ans, curr + v);
            // when we move forward,all sightseeing spot we have seen will be 1 distance further.
            curr = Math.max(curr, v) - 1;
        }
        return ans;
    }
}
