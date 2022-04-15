class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    
    public MinStack() {
        // constructor to initialize the stacks
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.offerFirst(val);
        if(minStack.isEmpty() || val <= minStack.peekFirst()){
            minStack.offerFirst(val);
        }
    }
    
    public void pop() {
        if (stack.pollFirst().equals(minStack.peekFirst())) {
            minStack.pollFirst();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */