class Solution {
    public int calPoints(String[] ops) {
        // Array Dequeue instead of inbuilt stack
        int sum = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String op : ops) {
            if(op.equals("C"))
            {
                if(!stack.isEmpty())
                    sum -= stack.pop();
            }else if(op.equals("D"))
            {
                int top = stack.peek();
                stack.push(2*top);
                sum +=2*top;
            }else if(op.equals("+"))
            {
                int top = stack.pop();
                int nextTop = top + stack.peek();
                stack.push(top);
                stack.push(nextTop);
                sum +=nextTop;
            }else {
                int v = Integer.valueOf(op);
                sum +=v;
                stack.push(v);
            }
        }

        return sum;
    }
}