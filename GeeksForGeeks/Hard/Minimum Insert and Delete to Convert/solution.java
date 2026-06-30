class Solution {

    public int minInsAndDel(int[] a, int[] b) {

     int n=a.length,m=b.length; // Step 1: Map elements of array b to their indices

        Map<Integer, Integer> bMap = new HashMap<>();

        for (int i = 0; i < m; i++) {

            bMap.put(b[i], i);

        }

 

        // Step 2: Filter array 'a' to only keep elements present in 'b', replaced by their indices

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (bMap.containsKey(a[i])) {

                list.add(bMap.get(a[i]));

            }

        }

 

        // Step 3: Find the Longest Increasing Subsequence (LIS) length in O(N log N) time

        int lisLength = findLIS(list);

 

        // Step 4: Minimum operations = (n - lisLength) + (m - lisLength)

        return n + m - 2 * lisLength;

    }

 

    private static int findLIS(List<Integer> list) {

        if (list.isEmpty()) return 0;

 

        List<Integer> tails = new ArrayList<>();

        for (int num : list) {

            int idx = Collections.binarySearch(tails, num);

            

            // If the element is not found, binarySearch returns (-(insertion point) - 1)

            if (idx < 0) {

                idx = -(idx + 1);

            }

 

            if (idx == tails.size()) {

                tails.add(num);

            } else {

                tails.set(idx, num);

            }

        }

        return tails.size();

    }

}