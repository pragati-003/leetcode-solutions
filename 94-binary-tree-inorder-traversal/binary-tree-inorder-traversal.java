class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        TreeNode curr = root;
        List<Integer> arr = new ArrayList<>();
        while(curr != null) {
            if(curr.left != null) { //find predecessor
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr){
                    pred = pred.right;
                }
                if(pred.right == null) { //connect pred with curr
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){  //unlink pred with curr
                    pred.right = null;
                    arr.add(curr.val);
                    curr = curr.right;
                }
            }
            else{  // curr.left = null, no pred
                arr.add(curr.val);
                curr = curr.right;
            }
        }
        return arr;
    }
}