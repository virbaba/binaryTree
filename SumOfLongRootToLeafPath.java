
import java.io.*;
import java.util.*;
import java.lang.*; 


/*
node class of binary tree
class Node {
    int data;
    Node left, right;
    
    public Node(int data){
        this.data = data;
    }
}
*/
class Solution{
    
    public int[] solve(Node root){
        if(root == null){
            // ans[0] for level & ans[1] for sum
            int[] ans = new int[2];
            ans[0] = 0;
            ans[1] = 0;
            return ans;
            
        }
        
        int[] left = solve(root.left);
        int[] right = solve(root.right);
        
        int[] ans = new int[2];
        
        // level is greater at left side
        if(left[0] > right[0]){
            ans[0] = left[0] + 1;
            ans[1] = left[1] + root.data;
        }
        // level is greater at right side
        else if(left[0] < right[0]){
            ans[0] = right[0] + 1;
            ans[1] = right[1] + root.data;
        }
        // if level is same
        else{
            // sum is greater and left side
            if(left[1] > right[1]){
                ans[0] = left[0] + 1;
                ans[1] = left[1] + root.data;
            }
            // sum is greater and right side
            else if(left[1] < right[1]){
                ans[0] = right[0] + 1;
                ans[1] = right[1] + root.data;
            }
            // mean sum is equll both side we can return any pair
            else{
                ans[0] = left[0] + 1;
                ans[1] = left[1] + root.data;
            }
        }
        
        return ans;
    }
    public int sumOfLongRootToLeafPath(Node root)
    {
        //code here
        
        int[] ans = solve(root);
      // return 1 index element which contain sum
        return ans[1];
         
    }
}
