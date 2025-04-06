class Solution:
    def countBits(self, n: int) -> List[int]:
        l=[0]*(n+1)
        for i in range(len(l)):
            halfpos=i//2
            if i%2==0:
                l[i]=l[halfpos]
            else:
                l[i]=l[halfpos]+1
        return l