class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        //Palindrome : 1 odd or all even
        for(char c:s.toCharArray()){
            count[c]++;
            
        }
        int res = 0;
        for(int c :count){
            res += c / 2*2;
            
            if(res%2==0 && c%2 == 1){
                res++;
            }
        }
        return res;
    }
}