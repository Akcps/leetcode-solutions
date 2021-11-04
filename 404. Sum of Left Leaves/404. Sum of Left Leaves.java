/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of Left Leaves.
 * Memory Usage: 37 MB, less than 53.62% of Java online submissions for Sum of Left Leaves.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    int sum = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        traverse(root);
        return sum;
    }

    public void traverse(TreeNode node) {
        if (node == null) {
            return;
        }
        if (node.left != null && node.left.left == null && node.left.right == null) {
            sum += node.left.val;
        }
        traverse(node.left);
        traverse(node.right);
    }
}