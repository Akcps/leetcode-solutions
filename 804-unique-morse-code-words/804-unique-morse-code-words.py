class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        mores = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        
        res = set()
        for word in words:
            trans = [mores[ord(ch)-97] for ch in word]
            res.add(''.join(trans))
        return len(res)