/************************************************************

 Following is the BinaryTreeNode class structure
 class BinaryTreeNode<T>
 {
     public:
     T data;
     BinaryTreeNode<T> left;
     BinaryTreeNode<T> right;
    
     BinaryTreeNode(T data)
     {
         this.data = data;
         left = null;
         right = null;
     }
 };

 RUN FOR:
       2
     /
   4
  /  \
 3    6

OUTPUT: 13
 ************************************************************/
public class Solution {

    private static int maxPathSumHelper(BinaryTreeNode<Integer> node, int[] maxSum) {
        if (node == null) {
            return 0;
        }

        int leftSum = Math.max(maxPathSumHelper(node.left, maxSum), 0);
        int rightSum = Math.max(maxPathSumHelper(node.right, maxSum), 0);

        int currentSum = node.data + leftSum + rightSum;
        maxSum[0] = Math.max(maxSum[0], currentSum);

        return node.data + Math.max(leftSum, rightSum);
    }
    public static int maxPathSum(BinaryTreeNode<Integer> root) {
       
       int[] maxSum = {Integer.MIN_VALUE}; // Initialize with minimum value
        maxPathSumHelper(root, maxSum);
        return maxSum[0];
        
    }
}
