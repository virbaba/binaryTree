import java.util.*;
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
      0
    /    \
   1       1
  /   \      \
 2      1      1
/   \         /   \
3     2      2      1
*/

public class Solution {
  
    public static ArrayList<ArrayList<Integer>> diagonal(TreeNode<Integer> root) {
        // Write your code here.

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;

        Queue<Integer> level = new LinkedList<>();
        Queue<TreeNode<Integer>> q = new LinkedList<>();
        TreeMap<Integer, ArrayList<Integer>> map = new TreeMap<>();

        level.offer(0);
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode<Integer> node = q.poll();
            if (node == null)
                continue;
            else {
                int lvl = level.poll();

                while (node != null) {
                    if (map.containsKey(lvl)) {
                        ArrayList<Integer> list = map.get(lvl);
                        list.add(node.data);
                        map.put(lvl, list);
                    } else {
                        ArrayList<Integer> list = new ArrayList<>();
                        list.add(node.data);
                        map.put(lvl, list);
                    }
                    if (node.left != null) {
                        level.offer(lvl + 1);
                        q.offer(node.left);
                    }

                    node = node.right;

                }
            }

        }

        for (ArrayList<Integer> list : map.values()) {
            ans.add(new ArrayList<>(list));
        }

        return ans;

    }
}
