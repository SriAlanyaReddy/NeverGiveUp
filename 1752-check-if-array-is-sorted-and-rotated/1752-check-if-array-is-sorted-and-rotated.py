class Solution:
    def check(self, nums: List[int]) -> bool:

        p=sorted(nums)

        i=0
        flag=0
        while i<=len(nums):
           x=nums.pop()
           nums.insert(0,x)
           if nums==p:
              flag=1
              break
           i=i+1
        return flag==1
