/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Build an Array With Stack Operations.
 * Memory Usage: 39.3 MB, less than 38.40% of Java online submissions for Build an Array With Stack Operations.
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 1,index = 0; index < target.length; i++) {
            result.add("Push");
            if (i < target[index]) {
                result.add("Pop");
            }
            if (i == target[index]) {
                index++;
            }
        }
        return result;
    }
}