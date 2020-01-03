/**
 * Runtime: 103 ms, faster than 81.39% of Java online submissions for Path With Maximum Minimum Value.
 * Memory Usage: 54.1 MB, less than 100.00% of Java online submissions for Path With Maximum Minimum Value.
 */
class Solution {
    public int maximumMinimumPath(int[][] A) {
        int r = A.length;
        int c = A[0].length;
        int min = Math.min(A[r-1][c-1], A[0][0]);
        //max heap
        PriorityQueue<Unit> pq = new PriorityQueue<>((x1,x2) -> x2.value - x1.value);
        int[][] visited = new int[r][c];
        int i = 0, j = 0;
        while(i != r-1 || j != c-1){
            visited[i][j] = 1;
            int cur = A[i][j];
            //up
            if(i-1 >= 0 && visited[i-1][j] == 0){
                visited[i-1][j] = 1;
                pq.add(new Unit(A[i-1][j], i-1, j));
            }
            //down
            if(i+1 < r && visited[i+1][j] == 0){
                if(reach(i+1,j,r,c))
                    return min;
                visited[i+1][j] = 1;
                pq.add(new Unit(A[i+1][j], i+1, j));
            }
            //left
            if(j-1 >= 0 && visited[i][j-1] == 0){
                visited[i][j-1] = 1;
                pq.add(new Unit(A[i][j-1], i, j-1));
            }
            //right
            if(j+1 < c && visited[i][j+1] == 0){
                if(reach(i,j+1,r,c))
                    return min;
                visited[i][j+1] = 1;
                pq.add(new Unit(A[i][j+1], i, j+1));
            }
            //pick next step
            Unit next = pq.poll();
            if(next.value < min)
                min = next.value;
            i = next.row;
            j = next.col;
        }
        return min;

    }
    public boolean reach(int i , int j , int r , int c){
        return i == r-1 && j == c-1;
    }

    public class Unit {
        public int value;
        public int row;
        public int col;

        public Unit(int value, int i , int j ){
            this.value = value;
            this.row = i;
            this.col = j;
        }
    }
}