class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        left = [1] * (len(nums) + 1)
        right = [1] * (len(nums) + 1)
        for i in range(len(nums)):
            left[i + 1] = left[i] * nums[i]
            right[len(nums) - i - 1] = right[len(nums) - i] * nums[len(nums) - i - 1]
        
        res = list()
        for i in range(len(nums)):
            res.append(left[i] * right[i+1])
        
        return res