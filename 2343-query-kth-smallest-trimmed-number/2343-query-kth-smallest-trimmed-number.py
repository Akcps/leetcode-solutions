class Solution:
    def smallestTrimmedNumbers(self, nums: List[str], qs: List[List[int]]) -> List[int]:
        rank = []
        for i in range(len(nums[0])):
            cur = sorted([(nums[k][-i-1:], k) for k in range(len(nums))])
            rank.append([r for _, r in cur])

        return [rank[j-1][i-1] for i, j in qs]
        