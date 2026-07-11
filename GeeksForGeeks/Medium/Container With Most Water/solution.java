class Solution {
    public int maxWater(int arr[]) {
        
        // Code Here
        int s = 0;
        int e = arr.length-1;
        
        int max = 0;
        
        while(s<e){
            int width = e-s;
            int h = Math.min(arr[s],arr[e]);
            int area = width*h;
            
            if(area>max){
                max = area;
            }
            
            if(arr[s]<arr[e]){
                s++;
            }
            else{
                e--;
            }
        }
        return max;
        
    }
}