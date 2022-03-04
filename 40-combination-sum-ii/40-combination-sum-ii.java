class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, ans, target,0, new ArrayList<>());
        return ans;
    }
    
     private void backtrack(int[] nums, List<List<Integer>> ans, int target,int start, List<Integer> curr){
        if(target <0) return;
        else if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=start;i<nums.length;i++){
            if(i>start && nums[i] == nums[i-1]) continue; //not using same sequence 
            curr.add(nums[i]);
            backtrack(nums,ans,target -nums[i],i+1,curr); 
            curr.remove(curr.size()-1);

        }
    }
    
}