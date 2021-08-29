/***
 * Runtime: 59 ms, faster than 18.63% of Java online submissions for Maximum Profit in Job Scheduling.
 * Memory Usage: 48.8 MB, less than 54.76% of Java online submissions for Maximum Profit in Job Scheduling.
 * Time Complexity: O (N log N)
 * Space Complexity: O (N)
 */

class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < startTime.length; i++) {
            Job job = new Job(startTime[i], endTime[i], profit[i]);
            jobs.add(job);
        }
        Collections.sort(jobs, (a, b) -> (a.endTime - b.endTime));
        TreeMap<Integer, Integer> profitMap = new TreeMap<>();

        int maxProfit = 0;

        for (Job job : jobs) {
            Integer keyTillStartTime = profitMap.floorKey(job.startTime);
            Integer profitTillStartTime = keyTillStartTime == null ? 0 : profitMap.get(keyTillStartTime);
            maxProfit = Math.max(maxProfit, profitTillStartTime + job.profit);
            profitMap.put(job.endTime, maxProfit);
        }
        return maxProfit;
    }

    class Job {
        int startTime;
        int endTime;
        int profit;

        public Job(int s, int e, int p) {
            this.startTime = s;
            this.endTime = e;
            this.profit = p;
        }
    }
}