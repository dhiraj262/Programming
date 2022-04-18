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
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        
        if(key < root.val){
            root.left = deleteNode(root.left,key);
        } else if(key > root.val){
            root.right = deleteNode(root.right,key);
        } else{
            if(root.left == null){
                return root.right;
            } 
            if(root.right == null){
                return root.left;
            }
            
            // IF both the children are present then find min in right side and replcae it.
            
            TreeNode min = findMin(root.right);
            root.val = min.val;
            root.right = deleteNode(root.right,min.val);
        }
        
        return root;
    }
    
    private TreeNode findMin(TreeNode root){
        while(root.left!=null){
            root = root.left;
        }
        return root;
    }
}