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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null) return null;
        
        return createTree(nums,0,nums.length-1);
    }
    private TreeNode createTree(int[] nums, int start,int end){
        
        if(start > end) return null;
        
        int mid = start + (end-start)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = createTree(nums,start, mid-1);
        root.right = createTree(nums,mid+1,end);
        
        return root;
    }
}