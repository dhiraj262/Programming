class Solution {
    public String minRemoveToMakeValid(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        char[] chars = s.toCharArray();
        Deque<Integer> deque = new ArrayDeque<>();
        
        // push invalid indices in deque
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') {
                deque.push(i);
            } else if (ch == ')') {
                if (deque.isEmpty()) {
                    chars[i] = '*';
                } else {
                    deque.pop();
                }
            } 
        }
         // mark invalid indices
        while (!deque.isEmpty()) {
            chars[deque.pop()] = '*';
        }
        
        StringBuilder ans = new StringBuilder();
        for (char c : chars) {
            if (c != '*') {
                ans.append(c);
            }
        }
        return ans.toString();
    }
}