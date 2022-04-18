/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class BSTIterator {
    private final Deque<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        TreeNode curr = root;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;   // get the leftmost smallest value
        }
    }
    
    public int next() {
        TreeNode node = stack.pop();
        TreeNode curr = node.right;
        while(curr!=null){
            stack.push(curr);
            curr = curr.left;      // get the smallest in the right of the smallest obtained in above function
        }
        
        return node.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */