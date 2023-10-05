import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T> 
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data) 
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/

import java.util.ArrayList;


public class Solution 
{   
   
    public static ArrayList<Integer> verticalOrderTraversal(TreeNode<Integer> root) 
    {
        ArrayList<Integer> result = new ArrayList<>();

        if (root == null) return result;

        TreeMap<Integer, ArrayList<Integer>> verticalLevels = new TreeMap<>();
        Queue<TreeNode<Integer>> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        nodeQueue.offer(root);
        levelQueue.offer(0);

        while (!nodeQueue.isEmpty()) {
            TreeNode<Integer> node = nodeQueue.poll();
            int level = levelQueue.poll();

            if (verticalLevels.containsKey(level)) {
                verticalLevels.get(level).add(node.data);
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(node.data);
                verticalLevels.put(level, list);
            }

            if (node.left != null) {
                nodeQueue.offer(node.left);
                levelQueue.offer(level - 1);
            }

            if (node.right != null) {
                nodeQueue.offer(node.right);
                levelQueue.offer(level + 1);
            }
        }

        for (ArrayList<Integer> levelList : verticalLevels.values()) {
            result.addAll(levelList);
        }

        return result;
    }
}
