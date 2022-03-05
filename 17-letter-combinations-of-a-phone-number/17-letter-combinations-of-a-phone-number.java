class Solution {
    String[] charArr = new String[]{ "0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if(digits.length() == 0) return ans;
        
        ans.add("");
        for(int i=0;i<digits.length();i++){
            int index = Character.getNumericValue(digits.charAt(i));
            while(ans.peek().length() == i){
                String per = ans.remove();
                
                for(char c: charArr[index].toCharArray()){
                    ans.add(per + c);
                }
            }
        }
        return ans;
    }
}