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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Insert into a Binary Search Tree.
 * Memory Usage: 38.4 MB, less than 100.00% of Java online submissions for Insert into a Binary Search Tree.
 */
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null)
            return null;
        insert(root, val);
        return root;
    }

    private void insert(TreeNode root, int val) {
        if (root == null)
            return;
        if (val < root.val) {
            insert(root.left, val);
        }

        if (root.val > val && root.left == null) {
            TreeNode n = new TreeNode(val);
            root.left = n;
            return;
        }
        if (root.val < val && root.right == null) {
            TreeNode n = new TreeNode(val);
            root.right = n;
            return;
        }

        if ( val > root.val) {
            insert(root.right, val);
        }
    }
}