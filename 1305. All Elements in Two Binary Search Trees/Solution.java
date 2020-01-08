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
 * Runtime: 15 ms, faster than 84.62% of Java online submissions for All Elements in Two Binary Search Trees.
 * Memory Usage: 40.8 MB, less than 100.00% of Java online submissions for All Elements in Two Binary Search Trees.
 */
class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        inOrderTraversal(root1, list1);
        List<Integer> list2 = new ArrayList<>();
        inOrderTraversal(root2, list2);
        return merge(list1, list2);
    }

    private void inOrderTraversal(TreeNode node, List<Integer> values) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, values);
        values.add(node.val);
        inOrderTraversal(node.right, values);
    }

    private List<Integer> merge (List<Integer> list1, List<Integer> list2) {
        List<Integer> result = new ArrayList<>();
        int l1 = 0;
        int l2 = 0;
        while (l1 < list1.size() && l2 < list2.size()) {
            if (list1.get(l1) < list2.get(l2)) {
                result.add(list1.get(l1));
                l1++;
            } else {
                result.add(list2.get(l2));
                l2++;
            }
        }
        while (l1 < list1.size()) {
            result.add(list1.get(l1));
            l1++;
        }
        while (l2 < list2.size()) {
            result.add(list2.get(l2));
            l2++;
        }
        return result;
    }
}