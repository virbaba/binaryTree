/*
    Time Complexity : O(N)
    Space Complexity : O(N)

    Where 'N' is the number of nodes in the given binary tree.
*/

import java.util.HashMap;
import java.util.Map;
public class Solution {

    // Constructs the subtree and returns the root node.
    private static TreeNode constructTree(int inStart, int inEnd, int[] pIndex, Map<Integer, Integer> inorderIndex, int[] inorder, int[] preorder) {
        if (inStart > inEnd) {
            // Subtree is empty.
            return null;
        }

        // Get root node value from preorder sequence.
        int rootNode = preorder[pIndex[0]];

        // Increment the index denoting the first element of preorder traversal.
        pIndex[0] = pIndex[0] + 1;

        // Create the root node with "rootNode" value.
        TreeNode root = new TreeNode(rootNode);

        if (inStart == inEnd) {
            // There is a single node in the given subtree.
            return root;
        } else {

            // Get the index of root node from the inorder sequence.
            int inIndex = inorderIndex.get(root.data);

            // Recur for the left subtree.
            TreeNode leftChild = constructTree(inStart, inIndex - 1, pIndex, inorderIndex, inorder, preorder);

            // Recur for the right subtree.
            TreeNode rightChild = constructTree(inIndex + 1, inEnd, pIndex, inorderIndex, inorder, preorder);

            // Link the left and right child to the root node.
            root.left = leftChild;
            root.right = rightChild;

            return root;
        }
    }

    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {

        // A HashMap to store the <nodeValue, index> pair of inorder sequence.
        Map<Integer, Integer> inorderIndex = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            // Storing key, value pair
            inorderIndex.put(inorder[i], i);
        }

        // Index of the first element of the preorder sequence
        int[] pIndex = {0};

        return constructTree(0, inorder.length - 1, pIndex, inorderIndex, inorder, preorder);
    }
}
