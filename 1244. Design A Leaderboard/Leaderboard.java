/**
 * Runtime: 17 ms, faster than 44.29% of Java online submissions for Design A Leaderboard.
 * Memory Usage: 41.3 MB, less than 100.00% of Java online submissions for Design A Leaderboard.
 */
class Leaderboard {

    Map<Integer, Player> scores;
    PriorityQueue<Player> heap;
    public Leaderboard() {
        scores = new HashMap<>();
        heap = new PriorityQueue<Player>((a, b) -> b.score - a.score);
    }

    public void addScore(int playerId, int score) {
        Player player;
        if (scores.containsKey(playerId)) {
            player = scores.get(playerId);
        } else {
            player = new Player(playerId, 0);
            scores.put(playerId, player);
        }
        heap.remove(player);
        player.addScore(score);
        heap.add(player);
    }

    public int top(int K) {
        Player[] temp = new Player[K];
        int sum = 0;
        for (int i = 0; i < K; i++) {
            Player player = heap.poll();
            sum += player.score;
            temp[i] = player;
        }
        for (Player p: temp) {
            heap.add(p);
        }
        return sum;
    }

    public void reset(int playerId) {
        Player player = scores.get(playerId);
        heap.remove(player);
        player.resetScore();
        heap.add(player);
    }

    class Player {
        int playerId;
        int score;

        public Player(int id, int sc) {
            this.playerId = id;
            this.score = sc;
        }

        public void addScore(int sc) {
            this.score += sc;
        }

        public void resetScore() {
            this.score = 0;
        }
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */