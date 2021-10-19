/**
 * Runtime: 6 ms, faster than 38.40% of Java online submissions for Next Greater Element I.
 * Memory Usage: 41.1 MB, less than 26.21% of Java online submissions for Next Greater Element I.
 */

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> stack = new Stack<>();

        HashMap<Integer, Integer> map = new HashMap<>();

        int[] res = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[i] > stack.peek()) {
                map.put(stack.pop(), nums2[i]);
            }
            stack.push(nums2[i]);
        }

        while (!stack.empty()) {
            map.put(stack.pop(), -1);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }

        return res;
    }
}