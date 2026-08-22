/* Structure of Binary Tree Node
class Node {
    int data;
    Node left;
    Node right;

    Node(int val) {
        data = val;
        left = right = null;
    }
} */

class Solution {

    public int numberOfTurns(Node root, int p, int q) {

        StringBuilder pathP = new StringBuilder();
        StringBuilder pathQ = new StringBuilder();

        if (!findPath(root, p, pathP) || !findPath(root, q, pathQ)) {
            return -1;
        }

        // Find common path
        int i = 0;
        while (i < pathP.length() &&
               i < pathQ.length() &&
               pathP.charAt(i) == pathQ.charAt(i)) {
            i++;
        }

        // p and q are same node
        if (i == pathP.length() && i == pathQ.length()) {
            return -1;
        }

        int turns = 0;

        // Direction from LCA to p
        if (i < pathP.length()) {
            for (int j = i + 1; j < pathP.length(); j++) {
                if (pathP.charAt(j) != pathP.charAt(j - 1)) {
                    turns++;
                }
            }
        }

        // Direction from LCA to q
        if (i < pathQ.length()) {
            for (int j = i + 1; j < pathQ.length(); j++) {
                if (pathQ.charAt(j) != pathQ.charAt(j - 1)) {
                    turns++;
                }
            }
        }

        // If both p and q are below the LCA,
        // moving from p-side to q-side itself creates a turn.
        if (i < pathP.length() && i < pathQ.length()) {
            if (pathP.charAt(i) != pathQ.charAt(i)) {
                turns++;
            }
        }

        return turns == 0 ? -1 : turns;
    }

    private boolean findPath(Node root, int target, StringBuilder path) {

        if (root == null) {
            return false;
        }

        if (root.data == target) {
            return true;
        }

        path.append('L');

        if (findPath(root.left, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        path.append('R');

        if (findPath(root.right, target, path)) {
            return true;
        }

        path.deleteCharAt(path.length() - 1);

        return false;
    }
}