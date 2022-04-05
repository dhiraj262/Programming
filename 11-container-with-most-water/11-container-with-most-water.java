class Solution {
    public int maxArea(int[] height) {
        
        int maxArea = 0;
        int start = 0, end = height.length-1;
        
        while(start < end){
            
            int h = height[start] < height[end] ?  height[start] : height[end];
            
            int area = h * (end -start);
            if(area > maxArea) maxArea = area;
            if(height[start] < height[end]) start++ ;
            else end--;
            
        }
        
        return maxArea;
    }
}