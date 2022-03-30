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
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
			return root;

	
		Queue<TreeNode> nodes = new LinkedList<TreeNode>();

		nodes.offer(root);

		while (!nodes.isEmpty()) {
			// remove from queue and swap children
			TreeNode currentNode = nodes.poll();
			// swap
			TreeNode temp = currentNode.left;
			currentNode.left = currentNode.right;
			currentNode.right = temp;

            // add to queue left and right if not null 
			if (currentNode.left != null)
				nodes.add(currentNode.left);
			if (currentNode.right != null)
				nodes.add(currentNode.right);
		}

		return root;
    }
}