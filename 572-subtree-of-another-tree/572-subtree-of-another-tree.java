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
class Solution {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // checking for null
       if(root==null) return false;
        
        if(root.val == subRoot.val && checkSame(root.left,subRoot.left) && checkSame(root.right,subRoot.right)) {
            return true;
        } else {
            return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
        }

    }
    
    private boolean checkSame(TreeNode r, TreeNode s){
        if(r == null && s == null ) return true;
        if(r == null || s == null ) return false;
        
        if(r.val == s.val && checkSame(r.left,s.left) && checkSame(r.right,s.right)){
            return true;
        } else {
            return false;
        }
    }
}