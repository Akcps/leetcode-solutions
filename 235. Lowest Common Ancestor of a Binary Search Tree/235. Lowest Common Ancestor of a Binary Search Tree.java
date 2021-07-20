/**
 * Runtime: 3 ms, faster than 100.00% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 * Memory Usage: 40.2 MB, less than 29.49% of Java online submissions for Lowest Common Ancestor of a Binary Search Tree.
 * Time Complexity : O (N)
 * Space Complexity: O (N)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > Math.max(p.val, q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < Math.min(p.val, q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        } else  {
            return root;
        }
    }
}