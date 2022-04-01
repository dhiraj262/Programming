/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        /*
        Case1: Both p & q are smaller than the root node, then both elements, as well as LCA, will be                     in the left subtree.
        Case2: Both are greater than the root node, then both elements, as well as LCA, will be in the                  right subtree.
        Case3: If 1 element is greater than the root and the other is smaller than the root, that means             both elements are in different subtrees. That means the root node is the LCA.
        */
        
         if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);
        
        else if (p.val > root.val && q.val > root.val)
            return lowestCommonAncestor(root.right, p, q);
        else return root;
    }
}