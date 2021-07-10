/**
 * Runtime: 3 ms, faster than 96.54% of Java online submissions for Find K Closest Elements.
 * Memory Usage: 41.3 MB, less than 23.47% of Java online submissions for Find K Closest Elements.
 * Time Complexity: O (log n + k)
 * Space Complexity: O(1)
 */
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int low = 0;
        int high = arr.length - k;

        while (low < high) {
            int mid = (low + high) / 2;
            if (x - arr[mid] > arr[mid + k] - x) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = low; i < low + k; i++) {
            result.add(arr[i]);
        }
        return result;
    }
}