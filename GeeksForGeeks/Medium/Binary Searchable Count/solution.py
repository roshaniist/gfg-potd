class Solution:
    def binarySearchable(self, arr):

        def dfs(left:int, right:int, lo: int, hi: int) -> int:
            if left > right or lo >= hi:
                return 0
            mid = left + (right - left) // 2
            return (
                int(lo < arr[mid] < hi)
                + dfs(left, mid - 1, lo, min(hi, arr[mid]))
                + dfs(mid + 1, right, max(lo, arr[mid]), hi)
            )

        return dfs(0, len(arr) - 1, min(arr) - 1, max(arr) + 1)
        # code here 