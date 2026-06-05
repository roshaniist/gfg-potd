# [Lexicographically smallest after removing k](https://www.geeksforgeeks.org/problems/lexicographically-smallest-after-removing-k/1)
## Medium
Given a string s consisting of n lowercase characters. Return the lexicographically smallest string after removing exactly&nbsp;k characters from the string. But you have to correct the value of k, i.e., if the length of the string is a power of 2, reduce k by half, else multiply k by 2. You can remove any k characters.
Note: If it is not possible to remove k (the value of k after correction) characters or if the resulting string is empty return&nbsp;-1. Examples:
Input: s = "fooland", k = 2Output: "and"&nbsp;Explanation: As the size of the string = 7 which is not a power of 2, hence k = 4. After removing 4 characters from the given string, the lexicographically smallest string is "and".

Input: s = "code", k = 4Output:&nbsp;"cd"Explanation: As the length of the string = 4, which is 2 to the power 2, hence k = 2. Hence, lexicographically smallest string after removal of 2 characters is "cd".
Constraints:1 ≤ n ≤ 1051 ≤ k ≤ 105