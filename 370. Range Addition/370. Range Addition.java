/**
 * Approach:
 * The idea is to utilize the fact that the array initializes with zero. The hint suggests us that we only needs
 * to modify the first and last element of the range. In fact, we need to increment the first element in the range
 * and decreases the last element + 1 (if it's within the length) by inc. Then we sum up all previous results.
 * Why does this work? When we sum up the array, the increment is passed along to the subsequent elements until
 * the last element. When we decrement the end + 1 index, we offset the increment so no increment is passed along
 * to the next element.
 */

/**
 * Runtime: 1 ms, faster than 100.00% of Java online submissions for Range Addition.
 * Memory Usage: 45.3 MB, less than 94.07% of Java online submissions for Range Addition.
 *
 * Time Complexity: O (n + k)
 * Space Complexity : O (n)
 */
class Solution {
    public int[] getModifiedArray(int length, int[][] updates) {
        int[] res = new int[length];
        for(int[] update : updates) {
            int value = update[2];
            int start = update[0];
            int end = update[1];

            res[start] += value;

            if(end < length - 1) {
                res[end + 1] -= value;
            }

        }

        int sum = 0;
        for(int i = 0; i < length; i++) {
            sum += res[i];
            res[i] = sum;
        }

        return res;

    }
}