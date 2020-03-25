/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Count Complete Tree Nodes.
 * Memory Usage: 45.3 MB, less than 9.76% of Java online submissions for Count Complete Tree Nodes.
 */
class Solution {
    int count = 0;
    public int countNodes(TreeNode root) {
        helper(root);
        return count;
    }
    private void helper(TreeNode node) {
        if (node == null) {
            return;
        }
        if ((node.left == null && node.right == null) || (node.left != null && node.right != null) || (node.left != null && node.right == null)) {
            count++;
        }
        helper(node.left);
        helper(node.right);
    }
}