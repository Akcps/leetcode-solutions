class Solution:
    
    def searchClosestRow(self, matrix: List[List[int]], target: int) -> int:
        low = 0
        high = len(matrix) - 1
        while low <= high:
            mid = (low + high) // 2
            if matrix[mid][0] == target:
                return mid
            
            if mid - 1 >= 0 and matrix[mid -1][0] < target and matrix[mid][0] > target:
                return mid - 1
            
            if matrix[mid][0] > target:
                high = mid - 1
            else:
                low = mid + 1
        
        if target <= matrix[0][0]:
            return 0
        
        return len(matrix) - 1
        
    
    def binarySearch(self, nums:List[int], target:int) -> bool:
        
        low = 0
        high = len(nums) - 1
        while low <= high:
            mid = (low + high) // 2
           
            if nums[mid] == target:
                return True
            
            if nums[mid] > target:
                high = mid - 1
            else:
                low = mid + 1
            
        return False
        
        
    def searchMatrix(self, matrix: List[List[int]], target: int) -> bool:
        row = self.searchClosestRow(matrix, target)
        if row == -1:
            row = 0
        return self.binarySearch(matrix[row], target)
        