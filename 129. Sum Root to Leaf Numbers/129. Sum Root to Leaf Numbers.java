/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum Root to Leaf Numbers.
 * Memory Usage: 36.6 MB, less than 64.91% of Java online submissions for Sum Root to Leaf Numbers.
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
    List<Integer> leaves = new ArrayList<>();

    public int sumNumbers(TreeNode root) {
        addleaves(root, 0);
        int s = 0;
        for (int i : leaves) {
            s += i;
        }
        return s;
    }

    private void addleaves(TreeNode root, int currentValue) {
        if (root == null) {
            return;
        }
        addleaves(root.left, currentValue * 10 + root.val);
        if (root.left == null && root.right == null) {
            leaves.add(currentValue * 10 + root.val);
        }
        addleaves(root.right, currentValue * 10 + root.val);
    }
}