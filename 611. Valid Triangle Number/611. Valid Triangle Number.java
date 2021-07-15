/**
 * Approch:
 * We sort the array first. We consider each num[i] (from index 2) as our third side and try to find all the pairs which
 * have sum greater than it only on the left of it. This will give us all the possible triangles with num[i] as the longest side.
 * All the sides on the right dont have num[i] as the longest side, so those will not be considered for index i.
 * Here, we use two pointers to find all the pair of sides on the left side.
 * If nums[start]+nums[end]> nums[i] , we can add all the sides between end and start. Because it is sorted so
 * definitely nums[start+1],nums[start+2].....,nums[end-1] are greater than nums[start] and all form valid triangles
 * with nums[end] and nums[i].
 */

/**
 * Runtime: 31 ms, faster than 82.31% of Java online submissions for Valid Triangle Number.
 * Memory Usage: 38.9 MB, less than 26.59% of Java online submissions for Valid Triangle Number.
 * Time Complexity: O(n^2)
 * Space Complexity: O (1)
 *
 */

class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 2; i < nums.length; i++) {
            int low = 0;
            int high = i - 1;
            while (low < high) {
                if (nums[low] + nums[high] > nums[i]) {
                    count += high -low;
                    high --;
                } else {
                    low++;
                }
            }
        }
        return count;
    }
}