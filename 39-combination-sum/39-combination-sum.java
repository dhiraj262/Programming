class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, ans, target,0, new ArrayList<>());
        return ans;
    }
    
     private void backtrack(int[] nums, List<List<Integer>> ans, int target,int start, List<Integer> curr){
        if(target <0) return;
        else if(target == 0){
            ans.add(new ArrayList<>(curr));
        }
        
        for(int i=start;i<nums.length;i++){
            curr.add(nums[i]);
            backtrack(nums,ans,target -nums[i],i,curr);  // not incrementing i because every element can be used more than once.
            curr.remove(curr.size()-1);

        }
    }
}