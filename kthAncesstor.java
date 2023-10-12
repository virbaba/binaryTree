import java.io.*;

import java.util.* ;
 
/*************************************************************

    Following is the Binary Tree node structure

    class BinaryTreeNode<T> {
	   T data;
	   BinaryTreeNode<T> left;
	   BinaryTreeNode<T> right;
	   
	   public BinaryTreeNode(T data) {
		   this.data = data;
	   }
    }

*************************************************************/

import java.util.*;


public class Solution {
    public static int solve(BinaryTreeNode<Integer> root, int targetNodeVal, int[] k){
       if(root == null)
            return -1;
        
        if(root.data == targetNodeVal)
            return root.data;
        
        int left = solve(root.left, targetNodeVal, k);
        int right = solve(root.right, targetNodeVal, k);

        int ans = -1;
        if(left == -1 && right == -1)
            return -1;
        // if left != -1 mean we found target node
        if(left != -1){
            k[0]--;
            if(k[0] == 0){
            // System.out.println(k[0]);
                ans = root.data;
                return ans;
            }
            return left;
        }

       // if right != -1 mean we found target node
        if(right != -1){
            k[0]--;
             if(k[0] == 0){
            // System.out.println(k[0]);
                ans = root.data;
                return ans;
            }
            return right;
            
        }
        
        return ans;
            
    }      
    static int findKthAncestor(BinaryTreeNode<Integer> root, int targetNodeVal, int kth) {
        // Write your code here.
        
        int[] k = new int[1];
        k[0] = kth;
        
        int ans = solve(root, targetNodeVal, k);
        if(k[0] > 0)
            return -1;
        return ans;
    }
}   
