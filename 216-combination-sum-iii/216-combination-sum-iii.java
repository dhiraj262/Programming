class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList();
        backtracking(k, n, result,new ArrayList<Integer>(), 1);
        return result;
    }
    private void backtracking(int k, int n, List<List<Integer>> result, ArrayList<Integer> list, int start){
        if (k < 0 || n <0)
            return;
        if (k==0 && n== 0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = start; i <=9; i++){
            list.add(i);
            backtracking(k-1, n-i, result, list, i+1);
            list.remove(list.size()-1);
        }
    }
}