class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int ans = 0, curr = 0;
        for (int v: values) {
            ans = Math.max(ans, curr + v);
            curr = Math.max(curr, v) - 1;
        }
        return ans;
    }
}