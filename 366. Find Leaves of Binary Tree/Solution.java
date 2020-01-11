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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Find Leaves of Binary Tree.
 * Memory Usage: 35.7 MB, less than 100.00% of Java online submissions for Find Leaves of Binary Tree.
 */
class Solution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        while (root != null) {
            List<Integer> leaves = new ArrayList<>();
            addLeaves(root, leaves);
            result.add(leaves);
            root = removeLeaves(root);
        }
        return result;
    }

    public void addLeaves(TreeNode root, List<Integer> leaves) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leaves.add(root.val);
            return;
        }
        addLeaves(root.left, leaves);
        addLeaves(root.right, leaves);
    }

    public TreeNode removeLeaves(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);
        return root;
    }
}