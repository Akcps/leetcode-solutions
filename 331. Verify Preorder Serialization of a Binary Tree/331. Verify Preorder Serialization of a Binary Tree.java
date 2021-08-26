/**
 * Runtime: 7 ms, faster than 15.59% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
 * Memory Usage: 40.9 MB, less than 5.83% of Java online submissions for Verify Preorder Serialization of a Binary Tree.
 * Time Complexity: O(N)
 * Space Complexity: O(N)
 */

class Solution {
    public boolean isValidSerialization(String preorder) {
        int slots = 1;

        for (String node : preorder.split(",")) {
            slots -= 1;

            if (slots < 0) {
                return false;
            }

            if (!node.equals("#")) {
                slots += 2;
            }
        }
        return slots == 0;
    }
}