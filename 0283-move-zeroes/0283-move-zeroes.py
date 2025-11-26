class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        pre=0
        for i in range(0,len(nums)):
            if nums[i]!=0:
                
                nums[i],nums[pre]=nums[pre],nums[i]
                pre=pre+1