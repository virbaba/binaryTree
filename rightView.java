/*************************************************************

    Following is the Binary Tree node structure:

    class BinaryTreeNode<Integer> {
        int data;
        BinaryTreeNode<Integer> left;
        BinaryTreeNode<Integer> right;
        public BinaryTreeNode(int data) {
            this.data = data;
        }
    }

*************************************************************/
import java.util.*;
public class Solution {
    public static ArrayList<Integer> printRightView(BinaryTreeNode<Integer> root) {
       // Write your code here.
       ArrayList<Integer> ans = new ArrayList<>();
        if(root == null)
            return ans;
            
        Queue<BinaryTreeNode<Integer>> nodeQ = new LinkedList<>();
        Queue<Integer> levelQ = new LinkedList<>();
        
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();
        
        levelQ.offer(0);
        nodeQ.offer(root);
        nodeQ.offer(null);
        
        while(true){
            BinaryTreeNode<Integer> node = nodeQ.poll();
            
            if(node == null && nodeQ.isEmpty())
                break;
            
            if(node == null){
                nodeQ.offer(null);
            }
            else{
                int level = levelQ.poll();
                
                if(map.containsKey(level)){
                    ArrayList<Integer> list = map.get(level);
                    list.add(0,node.data);
                    map.put(level, list);
                }
                else{
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(node.data);
                    map.put(level, list);
                }
                
                
                if(node.left != null){
                    levelQ.offer(level+1);
                    nodeQ.offer(node.left);
                }
                if(node.right != null){
                    levelQ.offer(level+1);
                    nodeQ.offer(node.right);
                }
            }
            
        }
        
        for (ArrayList<Integer> levelList : map.values()) {
            ans.add(levelList.get(0));
        }
        
        return ans;
    }
}
