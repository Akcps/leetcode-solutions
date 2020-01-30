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
 * Runtime: 16 ms, faster than 79.05% of Java online submissions for Binary Search Tree Iterator.
 * Memory Usage: 44.9 MB, less than 100.00% of Java online submissions for Binary Search Tree Iterator.
 */
class BSTIterator {

    List<TreeNode> list;
    int index;

    public BSTIterator(TreeNode root) {
        list = new ArrayList<TreeNode>();
        buildList(root);
        index = 0;
    }

    /** @return the next smallest number */
    public int next() {
        return list.get(index++).val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index < list.size();

    }

    private void buildList(TreeNode node) {
        if (node == null)
            return;
        if (node.left != null) {
            buildList(node.left);
        }
        list.add(node);
        if (node.right != null) {
            buildList(node.right);
        }
        return;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */