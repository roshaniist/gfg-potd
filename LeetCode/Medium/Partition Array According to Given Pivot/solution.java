class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n = nums.length ;
        int m = 0 ;
        int o = 0 ;
        int c = 0;
        for(int i = 0 ;i < n ;i++){
            if(nums[i]>pivot) m++;
            else if(nums[i]<pivot) o++;
            else c++;
        }
        int []less = new int[o];
        int []more = new int[m];
        int idxL =0;
        int idxG =0;
        for(int i = 0 ; i< n ; i++){
            if(nums[i]<pivot) less[idxL++]=nums[i];
            else if(nums[i]>pivot) more[idxG++]=nums[i];
        }
        int res []= new int[n];
        for(int i = 0 ;i < o;i++){
            res[i]= less[i];
        }
        for(int i = o;i<o+c;i++){
            res[i]=pivot;
        }
        for(int i = o+c ;i < c+o+m;i++){
            res[i]= more[i-o-c];
        }   
        return res;     
    }
}