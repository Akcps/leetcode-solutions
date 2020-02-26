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
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Binary Tree Inorder Traversal.
 * Memory Usage: 37.8 MB, less than 5.11% of Java online submissions for Binary Tree Inorder Traversal
 */
class Solution {
    List<Integer> inorders = new ArrayList<>();
    public List<Integer> inorderTraversal(TreeNode root) {
        // inOrderTraversal(root);
        inOrderIterative(root);
        return inorders;
    }

     private void inOrderTraversal(TreeNode root) {
         if (root == null)
             return;
         inOrderTraversal(root.left);
         inorders.add(root.val);
         inOrderTraversal(root.right);
     }

    private void inOrderIterative(TreeNode node) {
        Stack<TreeNode> st = new Stack<TreeNode>();
        TreeNode curr = node;
        while(!st.isEmpty() || curr != null) {

            while(curr != null) {
                st.add(curr);
                curr = curr.left;
            }
            curr = st.pop();
            inorders.add(curr.val);
            curr = curr.right;
        }
    }
}