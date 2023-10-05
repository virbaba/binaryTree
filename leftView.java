/*************************************************************

     Following is thr TreeNode class structure

     class BinaryTreeNode<T>
     {
         T data;
         BinaryTreeNode<T> left;
         BinaryTreeNode<T> right;

         BinaryTreeNode(T data) {
             this.data = data;
             left = null;
             right = null;
         }
     };

 *************************************************************/
 import java.util.*;
public class Solution {
    public static void printLeftView(TreeNode<Integer> root) {
        // Write your code here.
        if(root == null)
            return;
            
        Queue<TreeNode<Integer>> nodeQ = new LinkedList<>();
        Queue<Integer> xAxis = new LinkedList<>();
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        xAxis.offer(0);
        nodeQ.offer(root);
        nodeQ.offer(null);
        
        while(true){
            TreeNode<Integer> node = nodeQ.poll();
            
            if(node == null && nodeQ.isEmpty())
                break;
            
            if(node == null){
                nodeQ.offer(null);
            }
            else{
                int axis = xAxis.poll();
                
                if(!map.containsKey(axis)){
                   ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    map.put(axis, list);
                }
                
                
                if(node.left != null){
                    xAxis.offer(axis+1);
                    nodeQ.offer(node.left);
                }
                if(node.right != null){
                    xAxis.offer(axis+1);
                    nodeQ.offer(node.right);
                }
            }
            
        }
        
        for (ArrayList<Integer> levelList : map.values()) {
            System.out.print(levelList.get(0)+" ");
        }
        
    }
}
