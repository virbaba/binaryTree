import java.util.* ;
import java.io.*; 
/*

    Following is the TreeNode class for your referance:

    class TreeNode<T> {
        public T data;
        public TreeNode<T> left;
        public TreeNode<T> right;

        TreeNode(T data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

*/

import java.util.ArrayList;

public class Solution{
    public static ArrayList<ArrayList<Integer>> diagonal(TreeNode<Integer> root){
        // Write your code here.
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (root == null) return result;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                TreeNode<Integer> node = queue.poll();

                while (node != null) {
                    level.add(node.data);

                    if (node.left != null) {
                        queue.add(node.left);
                    }

                    node = node.right;
                }
            }

            result.add(level);
        }

        return result;
    }
}
