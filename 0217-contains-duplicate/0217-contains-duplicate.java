class Solution {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Boolean> present = new HashMap<>();
        for (int n: nums) {
            if (present.containsKey(n)) {
                return true;
            }
            present.put(n, true);
        }
        return false;
    }
}