class Solution {
    public int countOdds(int low, int high) {
        int diff = high - low;
        int count = diff / 2;
        
        if (low % 2 == 1) {
            count++;
        } else {
            if (high % 2 == 1) {
                count++;
            }
        }
        
        
        return count;
    }
}