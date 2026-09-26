class Solution:
    def minimumCost(self, x, s, m, l, cs, cm, cl):
        sc=[(s,cs,),(m,cm,),(l,cl,)]
        from functools import cache
        @cache
        def dp(x=x):
            nonlocal sc
            if x<=0:
                return 0
            mn=float('inf')
            for ix in range(3):
                mn=min(mn,dp(x-sc[ix][0])+sc[ix][1])
            return mn
        return dp()
