class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        for i in range(len(s)):
            if s.count(t[i])!=t.count(t[i]) or len(s)!=len(t):
                return False
        return True