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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Preorder Traversal.
 * Memory Usage: 37.8 MB, less than 5.17% of Java online submissions for Binary Tree Preorder Traversal.
 */
class Solution {
    List<Integer> preOrders = new ArrayList<>();

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null)
            return preOrders;

        preOrderIterative(root);
        // preOrderRecursive(root);
        return preOrders;
    }

    private void preOrderIterative(TreeNode root) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        st.add(root);

        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            preOrders.add(node.val);

            if (node.right != null) {
                st.add(node.right);
            }

            if(node.left != null) {
                st.add(node.left);
            }


        }
    }


    private void preOrderRecursive(TreeNode root) {
        if (root == null)
            return;

        preOrders.add(root.val);
        preOrderRecursive(root.left);
        preOrderRecursive(root.right);
    }
}