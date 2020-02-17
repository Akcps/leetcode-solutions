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
 * Runtime: 1 ms, faster than 32.25% of Java online submissions for Flatten Binary Tree to Linked List.
 * Memory Usage: 37.9 MB, less than 58.18% of Java online submissions for Flatten Binary Tree to Linked List.
 */
class Solution {
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode current = st.pop();
            if (current.right != null)
                st.add(current.right);
            if (current.left != null)
                st.add(current.left);
            if (!st.isEmpty()) {
                current.right = st.peek();
            }
            current.left = null;
        }
    }

}