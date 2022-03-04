class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(nums, ans, visited, new ArrayList<>());
        return ans;
        
    }
    
    private void backtrack(int[] nums, List<List<Integer>> ans, boolean[] visited,List<Integer> curr){
        if(curr.size() == nums.length){
            ans.add(new ArrayList<>(curr));
            return;
        }
        
        for(int i=0;i<nums.length;i++){
            
            if(visited[i] == true || i > 0 && nums[i] == nums[i-1] && !visited[i - 1]) continue;
            visited[i] = true;
            curr.add(nums[i]);
            backtrack(nums,ans,visited,curr);
            visited[i] = false;
            curr.remove(curr.size()-1);

        }
    }
}