class Solution:
    def exitPoint(self, mat):
        hth=len(mat)
        wth=len(mat[0])
        x,y,dx,dy=0,0,1,0
        while 1:
            if mat[y][x]==1:
                d=(dx+dy*1j)*1j
                dx=int(d.real)
                dy=int(d.imag)
                mat[y][x]=0
            x+=dx
            y+=dy
            if not(0<=x<wth and 0<=y<hth):
                return [y-dy,x-dx]
        # code here
        