class Solution {
    int n;
    public List<String> generateParenthesis(int n) {
        
        List<String> res = new ArrayList<>();
        this.n = n;
        backtrack(res,new StringBuilder(), 0, 0);
        return res;
    }
    
    private void backtrack(List<String> res, StringBuilder curr, int open, int close){
        
        if(curr.length() == this.n *2){
            res.add(curr.toString());
            return;
        } else if(open < this.n) {
            curr.append("(");
            backtrack(res,curr,open+1,close);
            curr.deleteCharAt(curr.length() -1);
        } 
        
        if(close < open ){
            curr.append(")");
            backtrack(res,curr,open,close+1);
            curr.deleteCharAt(curr.length() -1);
        }
    }
}