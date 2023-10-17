import java.util.*;
class Solution {
    private static TreeNode constructTree(int inStart, int inEnd, int[] pIndex, int[] inOrder, int[] postOrder, HashMap<Integer, Integer> map) {
         if (inStart > inEnd) {
            return null;
        }

        // Get root node value from postorder sequence.
        int rootNode = postOrder[pIndex[0]];

        // Create the root node with "rootNode" value.
        TreeNode root = new TreeNode(rootNode);

        // Decrement the index denoting the first element of postorder traversal.
        pIndex[0] = pIndex[0] - 1;

        if (inStart == inEnd) {
            // There is a single node in the given subtree.
            return root;
        } else {

            int index = map.get(root.val);

            // Recur for the right subtree before the left subtree.
            root.right = constructTree(index + 1, inEnd, pIndex, inOrder, postOrder, map);
            root.left = constructTree(inStart, index - 1, pIndex, inOrder, postOrder, map);

            return root;
        }
    }
    public TreeNode buildTree(int[] inOrder, int[] postOrder) {
        int[] pIndex = {postOrder.length - 1};
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inOrder.length; i++){
            map.put(inOrder[i], i);
        }
        return constructTree(0, inOrder.length - 1, pIndex, inOrder, postOrder, map);
    }
}
