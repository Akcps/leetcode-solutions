class Solution {
    
    public int shipWithinDays(int[] weights, int days) {
        int totalLoad = 0, maxLoad = 0;
        for (int weight : weights) {
            totalLoad += weight;
            maxLoad = Math.max(maxLoad, weight);
        }
        
        int low = maxLoad;
        int high = totalLoad;
        while (low < high) {
            int mid = (low + high) / 2;
            if (possible(weights, mid, days)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        
        return low;
    }
    
    private boolean possible (int[] weights, int capacity, int days) {
        int daysNeeded = 1, currentLoad = 0;
        for (int weight : weights) {
            currentLoad += weight;
            if (currentLoad > capacity) {
                daysNeeded++;
                currentLoad = weight;
            }
        }
        return daysNeeded <= days;
    }
}