class Solution {
    public int maxArea(int[] height) {
        int s = 0;
        int e = height.length-1;
        int max = 0;

        while(s<e){
            int width = e-s;
            int h = Math.min(height[s],height[e]);
            int area = width*h;

            if(area>max){
                max = area;
            }

            if(height[s]<height[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return max;
    }
}