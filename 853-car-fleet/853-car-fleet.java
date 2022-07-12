class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<Pair<Integer, Integer>> positionSpeedPairs = new ArrayList<>();
        for (int i = 0; i < position.length; i++) {
            positionSpeedPairs.add(new Pair(position[i], speed[i]));
        }
        Collections.sort(positionSpeedPairs, (a, b) -> b.getKey() - a.getKey());
        
        
        Stack<Double> stack = new Stack<>();
        
        for(Pair<Integer,Integer> p: positionSpeedPairs) {
            double val = (target - p.getKey()) / (double) p.getValue();
            if (stack.size() == 0) {
               stack.add(val); 
            } else if (stack.size() >= 1 && val > stack.peek()) {
                stack.add(val);
            }
        }
        return stack.size();
        
        
    }
}