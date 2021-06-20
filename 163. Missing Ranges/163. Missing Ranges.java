/***
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Missing Ranges.
 * Memory Usage: 37 MB, less than 96.08% of Java online submissions for Missing Ranges.
 */

class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int current = lower;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (current == nums[i]){
                current++;
            } else if (current < nums[i]) {
                StringBuilder sb = new StringBuilder();
                sb.append(String.valueOf(current));
                if (nums[i] - current > 1) {
                    sb.append("->");
                    sb.append(String.valueOf(nums[i] - 1));
                }
                result.add(sb.toString());
                current = nums[i] + 1;
            }
        }
        if (current <= upper) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(current));
            if (upper - current > 0) {
                sb.append("->");
                sb.append(String.valueOf(upper));
            }
            result.add(sb.toString());
        }
        return result;
    }
}