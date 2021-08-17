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
 * Runtime: 2 ms, faster than 96.95% of Java online submissions for Count Good Nodes in Binary Tree.
 * Memory Usage: 48 MB, less than 36.51% of Java online submissions for Count Good Nodes in Binary Tree.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */
class Solution {
    int count = 0;
    public int goodNodes(TreeNode root) {
        countGoodNodes(root, Integer.MIN_VALUE);
        return count;
    }

    private void countGoodNodes(TreeNode root, int max) {
        if (root == null) {
            return;
        }
        if (root.val >= max) {
            count++;
            max = Math.max(root.val, max);
        }
        countGoodNodes(root.left, max);
        countGoodNodes(root.right,max);
    }
}