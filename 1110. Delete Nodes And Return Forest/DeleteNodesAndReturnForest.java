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
 * Runtime: 1 ms, faster than 98.37% of Java online submissions for Delete Nodes And Return Forest.
 * Memory Usage: 41 MB, less than 100.00% of Java online submissions for Delete Nodes And Return Forest.
 */
class Solution {

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> toDelete = new HashSet<>();
        for (int del: to_delete)
            toDelete.add(del);

        List<TreeNode> res = new ArrayList<>();
        if (!toDelete.contains(root.val)) {
            res.add(root);
        }
        traverse(root, toDelete, res);
        return res;
    }

    private TreeNode traverse(TreeNode node, Set<Integer> toDelete, List<TreeNode> res) {
        if (node == null)
            return null;
        node.left = traverse(node.left, toDelete, res);
        node.right = traverse(node.right, toDelete, res);
        if (toDelete.contains(node.val)) {
            if (node.left != null)
                res.add(node.left);
            if (node.right != null)
                res.add(node.right);
            return null;
        }
        return node;
    }

}