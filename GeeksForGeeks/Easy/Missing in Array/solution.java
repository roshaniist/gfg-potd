class Solution {
    int missingNum(int arr[]) {
        int n = arr.length;

        long expectedSum = (long)(n + 1) * (n + 2) / 2;
        long actualSum = 0;

        for (int num : arr) {
            actualSum += num;
        }

        return (int)(expectedSum - actualSum);
    }
}