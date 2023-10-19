class Solution
{
   // finding the maxtime from current node to depth 
    public static void time(Node root, Node blockNode, int[] maxTime, int time){
        if(root == null || root == blockNode)
            return;
        
        maxTime[0] = Math.max(maxTime[0], time);
        time(root.left, blockNode, maxTime, time + 1);
        time(root.right, blockNode, maxTime, time + 1);
    }
    
    // finding the target node and calculate max burning time
    public static int findTargetNode(Node root, int target, int[] maxTime){
        if(root == null)
            return -1; 
        
        // target node found
        if(root.data == target){
            time(root, null, maxTime, 0);
            return 1;
        }
        
        int leftTime = findTargetNode(root.left, target, maxTime);
        // if left time is not -1 mean left subtree have some burning time
        if(leftTime != -1){
            time(root, root.left, maxTime, leftTime);
            return leftTime + 1;
        }
        
        int rightTime = findTargetNode(root.right, target, maxTime);
         // if right time is not -1 mean right subtree have some burning time
        if(rightTime != -1){
            time(root, root.right, maxTime, rightTime);
            return rightTime + 1;
        }
        
        return -1;
    }
    public static int minTime(Node root, int target) 
    {
        // Your code goes here
        int[] maxTime = {0};
        findTargetNode(root, target, maxTime);
        return maxTime[0];
        
    }
}
