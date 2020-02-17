/**
 * Runtime: 32 ms, faster than 32.45% of Java online submissions for K Closest Points to Origin.
 * Memory Usage: 48.5 MB, less than 100.00% of Java online submissions for K Closest Points to Origin.
 */
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(K, new              Comparator<Point>() {
            @Override
            public int compare(Point p1, Point p2) {
                if (p1.getDist() > p2.getDist())
                    return -1;
                else if (p1.getDist() < p2.getDist())
                    return 1;
                else
                    return 0;
            }
        });
        for (int i = 0; i < points.length; i++) {
            Point p = new Point(points[i][0], points[i][1]);
            if (maxHeap.size() == K) {
                if (p.getDist() < maxHeap.peek().getDist()) {
                    maxHeap.poll();
                    maxHeap.add(p);
                }
            } else {
                maxHeap.add(p);
            }
        }


        int[][] result = new int[maxHeap.size()][2];
        int c = 0;
        while (!maxHeap.isEmpty()) {
            Point p = maxHeap.poll();
            result[c][0] = p.x;
            result[c][1] = p.y;
            c++;
        }
        return result;
    }

    class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double getDist() {
            return Math.sqrt(x * x + y * y);
        }

        public String toString() {
            return new String (x + " ," + y);
        }

    }
}