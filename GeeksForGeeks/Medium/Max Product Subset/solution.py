class Solution:
    def findMaxProduct(self, arr):
        mod=10**9+7
        from functools import reduce
        nn=None
        n=[ve for ve in arr if ve<0]
        if len(n)>1:
            nn=reduce(lambda x,y:x*y,n)//(max(n) if len(n)%2==1 else 1)
        pp=None
        p=[ve for ve in arr if ve>0]
        if p:
            pp=reduce(lambda x,y:x*y,p)
        if pp!=None or nn!=None:
            return ((pp if pp!=None else 1)*(nn if nn!=None else 1))%mod
        return max(arr)
        # code here