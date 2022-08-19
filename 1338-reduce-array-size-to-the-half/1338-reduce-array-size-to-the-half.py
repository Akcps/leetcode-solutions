class Solution:
    def minSetSize(self, arr: List[int]) -> int:
        count = dict()
        
        for a in arr:
            if a not in count:
                count[a] = 1
            else:
                count[a] = count[a] + 1
                
        sum = res = 0
        for _, v in sorted(count.items(), key=lambda item: item[1],reverse=True):
            sum += v
            res += 1
            if sum * 2 >= len(arr):
                return res
        
        return -1
        