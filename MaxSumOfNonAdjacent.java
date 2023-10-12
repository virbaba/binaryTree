import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    template <typename T>
    class TreeNode {
       public:
        T data;
        TreeNode<T> *left;
        TreeNode<T> *right;

        TreeNode(T data) {
            this->data = data;
            left = NULL;
            right = NULL;
        }
    };

************************************************************/

public class Solution 
{
    private static int[] maxSum(TreeNode<Integer> node) {
        if (node == null) {
            // Both values of maximum sum of an empty tree will be 0
            return new int[]{0, 0};
        }

        // Initialise pair to calculate sum from left subtree and right subtree
        int[] left = maxSum(node.left);
        int[] right = maxSum(node.right);

        
		// The current node is included meaning that left and right children are not included
        int includeNode = node.data + left[1] + right[1];
        // The current node is not included meaning that either left or right children is included
        int excludeNode = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{includeNode, excludeNode};
    }

    public static int maximumSumOfNodes(TreeNode<Integer> root)
    {
        //    Write your code here.
        int[] result = maxSum(root);
        // Return maximum of the first and second values of the pair
        return Math.max(result[0], result[1]);

    }
}
