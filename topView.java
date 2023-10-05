/*********************************************

 Following is the TreeNode class structure

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 *********************************************/

import java.util.*;

public class Solution {
    public static List<Integer> getTopView(TreeNode root) {
        // Write your code here.
        // add your code here
        List<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
            
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> xAxis = new LinkedList<>();
        
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        
        xAxis.offer(0);
        nodeQ.offer(root);
        nodeQ.offer(null);
        
        while(true){
            TreeNode node = nodeQ.poll();
            
            if(node == null && nodeQ.isEmpty())
                break;
            
            if(node == null){
                nodeQ.offer(null);
            }
            else{
                int axis = xAxis.poll();
                
                if(!map.containsKey(axis)){
                    List<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    map.put(axis, list);
                }
                
                if(node.left != null){
                    xAxis.offer(axis-1);
                    nodeQ.offer(node.left);
                }
                if(node.right != null){
                    xAxis.offer(axis+1);
                    nodeQ.offer(node.right);
                }
            }
            
        }
        
        for (List<Integer> levelList : map.values()) {
            ans.addAll(levelList);
        }
        
        return ans;
    }
}
