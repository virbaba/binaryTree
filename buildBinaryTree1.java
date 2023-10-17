/*
    Time Complexity : O(N ^ 2)
    Space Complexity : O(N)

    Where 'N' is the number of nodes in the given binary tree.
*/

public class Solution {

    // Constructs the subtree and returns the root node.
    private static TreeNode constructTree(int inStart, int inEnd, int[] pIndex, int[] inorder, int[] preorder) {
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
            int index = -1;

            for (int i = inStart; i <= inEnd; i++) {
                if (rootNode == inorder[i]) {
                    // Root node value found.
                    index = i;
                    break;
                }
            }

            // Recur for the left subtree.
            TreeNode leftChild = constructTree(inStart, index - 1, pIndex, inorder, preorder);

            // Recur for the right subtree.
            TreeNode rightChild = constructTree(index + 1, inEnd, pIndex, inorder, preorder);

            // Link the left and right child to the root node.
            root.left = leftChild;
            root.right = rightChild;

            return root;
        }
    }

    public static TreeNode buildBinaryTree(int[] inorder, int[] preorder) {

        // Index of the first element of the preorder sequence
        int[] pIndex = {0};

        return constructTree(0, inorder.length - 1, pIndex, inorder, preorder);
    }
}
