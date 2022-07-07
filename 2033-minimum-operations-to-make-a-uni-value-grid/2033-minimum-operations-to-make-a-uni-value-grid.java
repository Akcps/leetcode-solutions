class Solution {
    public int minOperations(int[][] grid, int x) {
        List<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[0].length; j++) {
                list.add(grid[i][j]);
            }
        }
        
        Collections.sort(list);
        
        int res = 0;
        int middle = list.size() / 2;
        
        for(int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            int diff = Math.abs(num - list.get(middle));
            
            if(diff % x != 0) {
                return -1;
            }
            else {
                res += diff / x;
            }
        }
        
        return res;
    }
    
}