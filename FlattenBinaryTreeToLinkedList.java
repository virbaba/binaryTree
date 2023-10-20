class Solution {
    public void flatten(TreeNode root) {
        if(root == null)
			return;
		
		TreeNode current = root;

		while(current != null){
			if(current.left == null){
				current = current.right;
			}
			else{
				TreeNode pre = current.left;
				while(pre.right != null){
					pre = pre.right;
				}
				// we link most right node of current left node to current node or root
				if(pre.right == null){
				    pre.right = current.right;
				    current.right = current.left;
				    current.left = null;
				}
			}
		}
    }
}
