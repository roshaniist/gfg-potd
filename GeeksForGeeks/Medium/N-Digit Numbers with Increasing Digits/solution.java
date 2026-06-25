class Solution {
static int x = 0;
static ArrayList<Integer> ans;
public static ArrayList<Integer> increasingNumbers(int n) {
 
ans = new ArrayList<>();
if (n == 1)
ans.add(0);
x = n;
recurse(1, 0, 0);
return ans;
}
 
static void recurse(int i, int no, int count) {
if (count == x)
ans.add(no);
int number = no;
for (int z = i; z<10; z++) {
number = no;
number = number*10 + z;
recurse(z + 1, number, count + 1);
}
}
}