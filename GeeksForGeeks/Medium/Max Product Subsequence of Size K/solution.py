class Solution:
  def maxProduct(self, arr: list[int], k: int) -> int:
         from functools import cache
         n = len(arr)

         @cache
         def dfs(i: int = 0, rem: int = k, acc: int = 1):
             if rem == 0:
                 return acc
             ans = dfs(i + 1, rem - 1, acc * arr[i])
             if n - 1 - i >= rem:
                 ans = max(ans, dfs(i + 1, rem, acc))
             return ans

         return dfs()
        # code here
