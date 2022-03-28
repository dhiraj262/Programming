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
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> inorder = new ArrayList<>();
        
        TreeNode curr = root;
        TreeNode prev;
        
        while(curr != null){
            if(curr.left == null){
                inorder.add(curr.val);
                curr = curr.right;
            } else {
                prev = curr.left;
                while(prev.right !=null){
                    prev = prev.right;
                }
                
                prev.right = curr;
                TreeNode temp = curr;
                curr = curr.left;
                temp.left = null;
            }
            
            
        }
        
        return inorder;
    }
}