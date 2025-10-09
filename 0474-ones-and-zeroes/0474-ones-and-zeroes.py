from typing import List

class Solution:
    def findMaxForm(self, s: List[str], m: int, n: int) -> int:
        
        # Recursive function with 3D DP
        def find(ind, s, dp, m, n):
            if ind == 0:
                return 0
            if dp[ind][m][n] != -1:
                return dp[ind][m][n]
            
            ones = s[ind-1].count("1")
            zeros = len(s[ind-1]) - ones
            
            # Skip current string
            skip = find(ind-1, s, dp, m, n)
            
            # Take current string if enough zeros and ones
            take = 0
            if m >= zeros and n >= ones:
                take = 1 + find(ind-1, s, dp, m - zeros, n - ones)
            
            dp[ind][m][n] = max(skip, take)
            return dp[ind][m][n]
        
        length = len(s)
        # Initialize 3D DP array
        dp = [[[-1]*(n+1) for _ in range(m+1)] for _ in range(length+1)]
        
        # Call the recursive function
        return find(length, s, dp, m, n)
