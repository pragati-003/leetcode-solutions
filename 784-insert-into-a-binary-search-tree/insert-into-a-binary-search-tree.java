class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);
        //insertion
        if(root.val > val){
            if(root.left == null) root.left = new TreeNode(val);
            else insertIntoBST(root.left,val);
        } else { //root.val < val
            if(root.right == null) root.right = new TreeNode(val);
            else insertIntoBST(root.right,val);
        }
        return root;
    }
}