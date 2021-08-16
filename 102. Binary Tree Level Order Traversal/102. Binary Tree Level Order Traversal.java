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

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Level Order Traversal.
 * Memory Usage: 38.9 MB, less than 96.08% of Java online submissions for Binary Tree Level Order Traversal.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList();
        if (root == null) {
            return result;
        }
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> values = new ArrayList<>();
            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode node = queue.poll();
                values.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(values);
        }
        return result;
    }
}