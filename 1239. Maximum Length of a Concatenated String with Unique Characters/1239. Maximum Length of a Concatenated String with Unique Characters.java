/**
 * Runtime: 22 ms, faster than 59.45% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 * Memory Usage: 38.7 MB, less than 77.96% of Java online submissions for Maximum Length of a Concatenated String with Unique Characters.
 */
class Solution {

    public int maxLength(List<String> arr) {
        return maxString(arr, 0, "");
    }

    private int maxString(List<String> arr, int index, String res) {
        Set<Character> resSet = new HashSet<>();
        for (char c : res.toCharArray()) {
            resSet.add(c);
        }
        if (res.length() != resSet.size()) {
            return 0;
        }
        int maxLength = res.length();
        for (int i = index; i < arr.size(); i++) {
            maxLength = Math.max(maxLength, maxString(arr, i + 1, res + arr.get(i)));
        }
        return maxLength;
    }
}