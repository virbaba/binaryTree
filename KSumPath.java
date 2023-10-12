Kimport java.util.* ;
import java.io.*; 
/*************************************************************
    
    Following is the Binary Tree node structure.
    
    class BinaryTreeNode<T> {
	      T data;
	      BinaryTreeNode<T> left;
	      BinaryTreeNode<T> right;
 
	      BinaryTreeNode(T data) {
	          this.data = data;
	          left = null;
	          right = null;
	      }
	}
    
*************************************************************/

import java.util.ArrayList;

public class Solution {
    
    private static void kPathSumHelper(BinaryTreeNode<Integer> node, int k, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) return;

        path.add(node.data);

        kPathSumHelper(node.left, k, path, result);
        kPathSumHelper(node.right, k, path, result);

        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i);
            if (sum == k) {
                ArrayList<Integer> validPath = new ArrayList<>();
                for (int j = i; j < path.size(); j++) {
                    validPath.add(path.get(j));
                }
                result.add(new ArrayList<>(validPath));  // Add a copy of the validPath
            }
        }

        path.remove(path.size() - 1);// backtrack for remove 
        //last element from path
    }
    public static ArrayList < ArrayList < Integer >> kPathSum(BinaryTreeNode < Integer > root, int k) {
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        kPathSumHelper(root, k, path, result);
        return result;
    }
}

