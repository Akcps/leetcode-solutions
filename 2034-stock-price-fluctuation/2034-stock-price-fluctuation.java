class StockPrice {
    
    Map<Integer, Integer> stockMap; // timestamp to price
    TreeMap<Integer, List<Integer>> history; // price to timestamp(s)
    int latest = 0;

    public StockPrice() {
        this.stockMap = new HashMap<>();
        this.history = new TreeMap<>();
    }
    
    public void update(int timestamp, int price) {
        if (stockMap.containsKey(timestamp)) {
            int oldPrice = stockMap.get(timestamp);
            history.get(oldPrice).remove((Object)timestamp);
            if (history.get(oldPrice).size() == 0) {
                history.remove(oldPrice);
            }
        }
        
        history.putIfAbsent(price, new ArrayList<>());
        history.get(price).add(timestamp);
        
        stockMap.put(timestamp, price);
        
        latest = Math.max(timestamp, latest);
    }
    
    public int current() {
        return stockMap.get(latest);
    }
    
    public int maximum() {
        return history.lastKey();
    }
    
    public int minimum() {
        return history.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */