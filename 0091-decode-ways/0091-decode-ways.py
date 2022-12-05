class Solution:
    
    def numDecodings(self, s: str) -> int:
        memo = {}
        return self.numDecoding(s, 0, memo)
    
    def numDecoding(self, s: str, index:int, memo) -> int:
        if memo.get(index):
            return memo.get(index)
        
        if index == len(s):
            return 1
        

        if s[index] == "0":
            return 0

        
        
        if index + 1 == len(s):
            return 1
    
        count = self.numDecoding(s, index + 1, memo)
        
        if index + 1 < len(s): 
            i = int(s[index :index + 2])
            
            if i <= 26:
                count += self.numDecoding(s, index + 2, memo)
        
        memo[index] = count
        return count