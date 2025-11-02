class DSU:
    def __init__(self,n):
       self.parent=[i for i in range(n)]
       self.rank=[0]*n
    def findparent(self,x):
        if self.parent[x]!=x:
            self.parent[x]=self.findparent(self.parent[x])
        return self.parent[x]
    def union(self,x,y):
        rootx=self.findparent(x)
        rooty=self.findparent(y)
        if rootx==rooty:
            return False
        elif self.rank[rootx]>self.rank[rooty]:
            self.parent[rooty]=rootx
        elif self.rank[rootx]<self.rank[rooty]:
            self.parent[rootx]=rooty
        else:
             self.parent[rooty]=rootx
             self.rank[rootx]+=1
        return True
    


class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n=len(isConnected)
        dsu=DSU(n)
        for i in range(n):
            for j in range(n):
                if isConnected[i][j]==1 and i!=j:
                    dsu.union(i,j)
        c=0
        for  i in range(n):
            if dsu.parent[i]==i:
                c+=1
        return c
        

        