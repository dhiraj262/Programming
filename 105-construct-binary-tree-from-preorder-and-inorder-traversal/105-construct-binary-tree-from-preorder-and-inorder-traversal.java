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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return createTree(0,0,inorder.length-1,preorder,inorder);
    }
    
    private TreeNode createTree(int preStart, int inStart,int inEnd,int[] preorder,int[] inorder){
        //finding the root node and then splitting it into left and right
        if(preStart > preorder.length-1 || inStart > inEnd){
            return null;
        }
        //preorder - root ->left ->right
        TreeNode root = new TreeNode(preorder[preStart]);
        int index = 0; // finding index of current root in inorder
        for(int i=inStart;i<=inEnd;i++){
            if(inorder[i] == root.val){
                index = i;  // root index in inorder. 0 -> i -left  and i - end ->right
            }
        }
        root.left = createTree(preStart+1, inStart, index-1,preorder,inorder);
        root.right = createTree(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return root;
    }
}