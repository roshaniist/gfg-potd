class Solution:
    def profession(self, level, pos):
        # Count set bits in (pos - 1)
        cnt = bin(pos - 1).count('1')

        if cnt % 2 == 0:
            return "Engineer"
        else:
            return "Doctor"
        # code here
        