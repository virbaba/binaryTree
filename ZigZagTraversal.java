import java.util.* ;

import java.io.*; 
/*
	Following is the class used to represent the object/node of the Binary Tree

	class BinaryTreeNode<T> {
	    T data;
	    BinaryTreeNode<T> left;
	    BinaryTreeNode<T> right;

	    public BinaryTreeNode(T data) {
	        this.data = data;
	    }
	}
*/

public class Solution {
	public static List<Integer> zigZagTraversal(BinaryTreeNode<Integer> root) {
		// Write your code here!
		List<Integer> ans = new ArrayList<>();

		if(root == null)
			return ans;
		
		boolean s1 = false, s2 = true;

		Stack<BinaryTreeNode<Integer>> S1 = new Stack<>();
		Stack<BinaryTreeNode<Integer>> S2 = new Stack<>();

		S1.push(null);
		S1.push(root);
		S2.push(null);

		BinaryTreeNode<Integer> temp = null;
		while(true){
			// if s1 true mean push into s1 and pop into s2
			if(s1)
				temp = S2.pop();
			if(s2)
				temp = S1.pop();
			
			if(temp == null){

				if(S1.isEmpty())
					S1.push(null);
				if(S2.isEmpty())
					S2.push(null);
				
				if(S1.peek()== null && S2.peek() == null)
					break;
				
				if(s1){
					s1 = false;
					s2 = true;
				}
				else{
					s1 = true;
					s2 = false;
				}

			}

			else if(s1){
				ans.add(temp.data);
				if(temp.right != null)
					S1.push(temp.right);
				if(temp.left != null)
					S1.push(temp.left);
			}
			else if(s2){
				ans.add(temp.data);
				if(temp.left != null)
					S2.push(temp.left);
				if(temp.right != null)
					S2.push(temp.right);
			}



		}

		return ans;

	}
}
