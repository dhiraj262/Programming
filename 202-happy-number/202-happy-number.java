class Solution {
    public boolean isHappy(int n) {
        
        int slow = n;
        int fast = squareDigits(n);
        while(fast!=1 && slow!=fast){
            slow = squareDigits(slow);
            fast = squareDigits(squareDigits(fast));
        }
        if(fast==1) return true;
        
        return false;
        
    }
    
    private int squareDigits(int n){
        int s = 0;
        while(n>0){
            int digit = n%10;
            s  += digit*digit;
            n /=10;
        }
        return s;
    }
}