/**
 * Runtime: 5 ms, faster than 81.82% of Java online submissions for Find All Numbers Disappeared in an Array.
 * Memory Usage: 47.2 MB, less than 97.03% of Java online submissions for Find All Numbers Disappeared in an Array.
 */
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {


            int newIndex = Math.abs(nums[i]) - 1;

            if (nums[newIndex] > 0) {
                nums[newIndex] *= -1;
            }
        }

        List<Integer> result = new LinkedList<Integer>();

        for (int i = 1; i <= nums.length; i++) {

            if (nums[i - 1] > 0) {
                result.add(i);
            }
        }

        return result;
    }
}