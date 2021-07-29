/**
 * Runtime: 1 ms, faster than 88.07% of Java online submissions for Binary Tree Longest Consecutive Sequence.
 * Memory Usage: 40.4 MB, less than 52.28% of Java online submissions for Binary Tree Longest Consecutive Sequence.
 * Time Complexity: O (N)
 * Space Complexity: O (N)
 */
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
    public int longestConsecutive(TreeNode root) {
        return dfs(root, null, 0);
    }

    private int dfs(TreeNode p, TreeNode parent, int length) {
        if (p == null) {
            return length;
        }
        length = (parent != null && p.val == parent.val + 1) ? length + 1 : 1;

        return Math.max(length, Math.max(dfs(p.left, p, length), dfs(p.right, p, length)));
    }
}