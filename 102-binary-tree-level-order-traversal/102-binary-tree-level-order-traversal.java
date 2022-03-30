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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> nodes = new LinkedList<>();
        List<List<Integer>> levelOrder = new ArrayList<>();
        if(root ==null )return levelOrder;
        nodes.add(root);
        
        while(!nodes.isEmpty()){
            int level = nodes.size();
            
            List<Integer> temp = new ArrayList<>();
            for(int i=0;i<level;i++){
                if(nodes.peek().left !=null) nodes.offer(nodes.peek().left);
                if(nodes.peek().right !=null) nodes.offer(nodes.peek().right);
                temp.add(nodes.poll().val);
            }
            
            levelOrder.add(temp);
            
            
        }
        
        return levelOrder;
    }
}