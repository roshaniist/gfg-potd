class Solution:
   def lexicographicallySmallest(self, s, k):
        # code here 
        n = len(s)
        if n&(n-1)==0:
            k = k//2
        else:
            k = k*2
        if k>=n:
            return "-1"
        
        stack = []
        for ele in s:
            while stack and k!=0 and stack[-1]>ele:
                stack.pop()
                k-=1
            stack.append(ele)
            
        while k:
            stack.pop()
            k-=1
            
        return ''.join(stack) if k==0 else "-1"
        # code here 
        

# Synced seamlessly with LeetHub Pro
# Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
# Get it here: https://chromewebstore.google.com/detail/leethub-v4/bcilpkkbokcopmabingnndookdogmbna