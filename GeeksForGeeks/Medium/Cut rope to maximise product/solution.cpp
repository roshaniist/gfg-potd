class Solution {
public:
    int maxProduct(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int q = n / 3;
        int r = n % 3;

        if (r == 0)
            return pow(3, q);

        if (r == 1)
            return pow(3, q - 1) * 4;

        return pow(3, q) * 2; // r == 2
    }
};