class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int ans = 0;
		if (intervals.length == 0) {
			return ans;
		}

		Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));
		int prev = intervals[0][1];

		for (int i = 1; i < intervals.length; i++) {
			if(prev > intervals[i][0]) {
				prev = Math.min(prev, intervals[i][1]);
				ans++;
			} else {
				prev = intervals[i][1];
			}		
        }

		return ans;
    }
}