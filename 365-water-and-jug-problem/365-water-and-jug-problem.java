class Solution {
    public boolean canMeasureWater(int jug1Capacity, int jug2Capacity, int targetCapacity) {
        
        if(jug1Capacity + jug2Capacity < targetCapacity) return false;
        
        if(targetCapacity == jug1Capacity || (jug1Capacity + jug2Capacity) == targetCapacity || jug2Capacity == targetCapacity) return true;
        
        
        return targetCapacity % gcd(jug1Capacity,jug2Capacity)==0;
    }
    
    private int gcd(int x,int y){
     
        while(y!=0){
            int temp = y;
            y = x%y;
            x = temp;
        } 
        return x;
    }
}