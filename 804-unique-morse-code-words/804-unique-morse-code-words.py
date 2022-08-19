class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        map_value = [".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."]
        
        res = set()
        for word in words:
            trans = ""
            for ch in word:
                trans += map_value[ord(ch)-97]
            res.add(trans)
        return len(res)