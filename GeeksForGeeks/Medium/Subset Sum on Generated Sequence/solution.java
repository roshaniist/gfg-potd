class Solution {
    public boolean isPossible(int[] arr, int s, int x) {
        if (x == 0) return true;
        if (s > x) return false;

        ArrayList<Integer> seq = new ArrayList<>();
        seq.add(s);

        long sum = s;

        for (int val : arr) {
            if (sum > x) break;

            long next = sum + val;
            if (next > x) break;

            seq.add((int) next);
            sum += next;
        }

        int rem = x;

        for (int i = seq.size() - 1; i >= 0; i--) {
            int v = seq.get(i);
            if (v <= rem) rem -= v;
        }

        return rem == 0;
    }
}