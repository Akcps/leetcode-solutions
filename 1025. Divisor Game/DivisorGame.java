/**
 * Runtime: 0 ms, faster than 100.00% of Java online submissions for Divisor Game.
 * Memory Usage: 36 MB, less than 88.98% of Java online submissions for Divisor Game.
 */

/**
 * Optimal way to win this game is to stay on even numbers. When a player has to make a move if its odd number,
 * no matter what he does he will end up converting into a even number. If its a even number player has the
 * comfort of converting it into a odd number by substracting 1 to make it odd (N%1==0).
 * On his next turn he will get the even number again.
 */
class Solution {
    public boolean divisorGame(int N) {
        return N % 2 == 0;
    }
}