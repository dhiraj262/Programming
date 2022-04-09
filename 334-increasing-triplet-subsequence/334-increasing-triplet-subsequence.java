class Solution {
    public boolean increasingTriplet(int[] nums) {
        
        
        int firstMax = Integer.MAX_VALUE, seconsMax = Integer.MAX_VALUE;
        for (int n : nums)
            if (n <= firstMax)
                firstMax = n;
            else if (n <= seconsMax)
                seconsMax = n;
            else
                return true;
        return false;
    }
}