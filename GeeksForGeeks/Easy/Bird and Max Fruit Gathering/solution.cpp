


class Solution {
public:
    int maxFruits(vector<int>& arr, int m) {
        int maxi = 0;
        vector<int> pre;
        int sum = 0;
        for(int i = 0;i<arr.size();i++){
            sum += arr[i];
            pre.push_back(sum);
        }
        for(int i = 0;i<arr.size();i++){
            if(i > 0){
                if(i+m-1 >= arr.size()){
                    int a = arr.size()-1-i+1;
                    int b = pre[arr.size()-1] - pre[i-1];
                    int c = m - a;
                    b = b + pre[c-1];
                    maxi = max(maxi,b);
                }
                else{
                    maxi = max(maxi,pre[i+(m-1)]-pre[i-1]);
                }
            }
            else{
                maxi = max(maxi,pre[i+(m-1)]);
            }
        }
        return maxi;
    }
};