class Solution {
    
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> distinct = new HashSet<>();
        for (int n: nums) {
            if (distinct.contains(n)) {
                return true;
            } else {
                distinct.add(n);
            }
        }
        return false;
    }
}