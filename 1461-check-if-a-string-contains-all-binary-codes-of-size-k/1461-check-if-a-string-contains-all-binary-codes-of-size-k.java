class Solution {
    public boolean hasAllCodes(String s, int k) {
        
        int need = 1<<k;// 2^k
        Set<String> got = new HashSet<String>();
        
        for(int i=k;i<=s.length();i++){
            String str = s.substring(i-k,i);
            if(!got.contains(str)){
                got.add(str);
                need--;
                if(need == 0){
                    return true;
                }
            }
        }
        return false;
    }
}