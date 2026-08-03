import java.util.Arrays;

class Solution {
    public static int countPairs(int arr[], int k) {
        Arrays.sort(arr);

        int n = arr.length;
        int i = 0, j = 1;
        int count = 0;

        while (j < n) {
            if (arr[j] - arr[i] < k) {
                count += (j - i);
                j++;
            } else {
                i++;
                if (i == j) {
                    j++;
                }
            }
        }

        return count;
    }
}