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
        List<List<Integer>> result = new ArrayList<>();
        
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        queue.add(null);
        
        List<Integer> currentLevel = new ArrayList<>();
        while(!queue.isEmpty()) {
            TreeNode polledValue = queue.poll();
            if (polledValue != null) {
                currentLevel.add(polledValue.val);
                if (polledValue.left != null) {
                    queue.add(polledValue.left);
                }
                if (polledValue.right != null) {
                    queue.add(polledValue.right);
                }
            } else {
                result.add(currentLevel);
                if (!queue.isEmpty()) {
                    queue.add(null);
                    currentLevel = new ArrayList<>();
                } 
            }
        }
        return result;
    }
}