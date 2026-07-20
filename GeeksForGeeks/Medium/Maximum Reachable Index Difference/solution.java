class Solution {
    public int maxIndexDifference(String s) {
        int n = s.length();
        int[] best = new int[26];
        for (int i = 0; i < 26; i++) best[i] = -1;

        int ans = -1;
        boolean hasA = false;

        for (int i = n - 1; i >= 0; i--) {
            int c = s.charAt(i) - 'a';

            int reach;
            if (c == 25) {
                reach = i;
            } else if (best[c + 1] != -1) {
                reach = best[c + 1];
            } else {
                reach = i;
            }

            best[c] = Math.max(best[c], reach);

            if (c == 0) {
                hasA = true;
                ans = Math.max(ans, reach - i);
            }
        }

        return hasA ? ans : -1;
    }
}