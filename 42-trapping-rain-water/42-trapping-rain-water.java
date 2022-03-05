class Solution {
    public int trap(int[] height) {
        
        Stack<Integer> stack = new Stack<>();
        int maxWater =0, start = 0;
        while( start < height.length){
            while(!stack.isEmpty() && height[start]> height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()) break;
                
                int water = start - stack.peek() -1;
                int bHeight = Math.min(height[start],height[stack.peek()]) -height[top];
                maxWater +=water * bHeight; 
            }
            stack.push(start++);
        }
        
        return maxWater;
    }
}