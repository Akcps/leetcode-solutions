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
 * Runtime: 4 ms, faster than 84.01% of Java online submissions for Most Frequent Subtree Sum.
 * Memory Usage: 42.2 MB, less than 5.26% of Java online submissions for Most Frequent Subtree Sum.
 */
class Solution {
    Map<Integer, Integer> countMap = new HashMap<>();
    int max = 0;
    public int[] findFrequentTreeSum(TreeNode root) {
        subTreeSum(root);
        List<Integer> result = new ArrayList<>();
        for (int key: countMap.keySet()) {
            if (countMap.get(key) == max) {
                result.add(key);
            }
        }
        int[] arr = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            arr[i] = result.get(i);
        }
        return arr;
    }

    private int subTreeSum(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = subTreeSum(node.left);
        int right = subTreeSum(node.right);
        int value = left + right + node.val;
        countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        max = Math.max(max, countMap.get(value));
        return value;
    }
}