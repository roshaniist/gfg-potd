class Solution {
  public:
    int maxPeopleDefeated(int p) {
        int i=1;
        int sum=0;
        int temp=0;
        while(p>=(sum+temp)){
            sum+=(i*i);
            i++;
            temp=i*i;
        }
        return i-1;
    }
};
