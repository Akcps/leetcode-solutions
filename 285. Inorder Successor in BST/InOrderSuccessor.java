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
 * Runtime: 2 ms, faster than 92.87% of Java online submissions for Inorder Successor in BST.
 * Memory Usage: 41.6 MB, less than 5.26% of Java online submissions for Inorder Successor in BST.
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (p.right != null) {
            TreeNode cur = p.right;
            while(cur.left != null) {
                cur = cur.left;
            }
            return cur;
        }

        Stack<TreeNode> st = new Stack<TreeNode>();
        int predessor = Integer.MIN_VALUE;

        while(!st.isEmpty() || root != null) {

            while(root != null) {

                st.push(root);
                root = root.left;
            }

            root =  st.pop();

            if (predessor == p.val) return root;

            predessor = root.val;

            root = root.right;
        }

        return null;
    }
}