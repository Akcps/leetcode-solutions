/**
 * Runtime: 618 ms, faster than 15.57% of Java online submissions for Campus Bikes.
 * Memory Usage: 90.7 MB, less than 100.00% of Java online submissions for Campus Bikes.
 */
class Solution {
    private class WorkerBike implements Comparable<WorkerBike> {
        int distance;
        int worker;
        int bike;

        public WorkerBike(int d, int w, int b) {
            distance = d;
            worker = w;
            bike = b;
        }

        @Override
        public int compareTo(WorkerBike t) {
            if (t.distance == this.distance) {
                if (t.worker == this.worker) {
                    return Integer.compare(this.bike, t.bike);
                }
                return Integer.compare(this.worker, t.worker);
            }
            return Integer.compare(this.distance, t.distance);
        }
    }

    public int[] assignBikes(int[][] workers, int[][] bikes) {
        int[] result = new int[workers.length];
        Arrays.fill(result, -1);

        PriorityQueue<WorkerBike> pq = new PriorityQueue();
        for (int i = 0; i < workers.length; i++) {
            for (int j = 0; j < bikes.length; j++) {
                int mDist = Math.abs(workers[i][0] - bikes[j][0]) +
                        Math.abs(workers[i][1] - bikes[j][1]);
                pq.add(new WorkerBike(mDist, i, j));
            }
        }

        Set<Integer> used = new HashSet();
        while (!pq.isEmpty()) {
            WorkerBike t = pq.poll();
            if (result[t.worker] == -1 && !used.contains(t.bike)) {
                result[t.worker] = t.bike;
                used.add(t.bike);
            }
        }

        return result;
    }
}