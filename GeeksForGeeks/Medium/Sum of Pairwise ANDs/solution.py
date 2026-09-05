class Solution:
    def pairAndSum(self, arr):
        # code here
        bn = ''
        carry = 0
        for i in range(32):
            ones = 0
            for j in arr:
                ones += 1 if (j & (1 << i)) > 0 else 0 
            carry += ((ones - 1)*ones)//2
            bn = ('1' if (carry & 1 == 1) else '0') + bn
            carry >>= 1

        bn = bin(carry) + bn
        return int(bn, 2)
        # code here
        