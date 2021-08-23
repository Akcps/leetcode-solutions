/**
 * Runtime: 2 ms, faster than 97.13% of Java online submissions for Two Sum IV - Input is a BST.
 * Memory Usage: 39.6 MB, less than 91.98% of Java online submissions for Two Sum IV - Input is a BST.
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

    Set<Integer> set;

    public boolean findTarget(TreeNode root, int k) {
        set = new HashSet<>();
        return traverse(root, k);
    }

    private boolean traverse(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        boolean flag = traverse(root.left, k);
        if (set.contains(k - root.val)) {
            return true;
        } else {
            set.add(root.val);
        }
        flag = flag || traverse(root.right, k);
        return flag;
    }
}