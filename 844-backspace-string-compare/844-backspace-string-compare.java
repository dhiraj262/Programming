class Solution {
    public boolean backspaceCompare(String s, String t) {
        return buildString(s).equals(buildString(t));
    }
    
    private String buildString(String str){
        StringBuilder s = new StringBuilder();
        int hashCount = 0;
        int i = str.length()-1;
        while(i >=0){
            
            char ch = str.charAt(i);
            
            if(ch == '#') hashCount++;
            
            else {
                
                if(hashCount > 0) hashCount--;
                
                else {
                    s.append(ch);
                }
            }
            i--;
        }
        return s.toString();
    }
}