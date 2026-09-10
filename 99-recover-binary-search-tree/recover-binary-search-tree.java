class Solution {
    public void recoverTree(TreeNode root) {
        TreeNode curr = root;
        TreeNode prev = null;
        TreeNode prevPrev = null;
        List<TreeNode> arr = new ArrayList<>();
        while(curr != null) {
            if(curr.left != null) { // find pred
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }
                if(pred.right == null) {  // connect pred with curr
                    pred.right = curr;
                    curr = curr.left;
                }else {  // pred.right = curr, unlink
                    pred.right = null;
                    //visit
                    if(prev != null && prevPrev != null) {
                        if(prev.val > curr.val && prev.val > prevPrev.val) arr.add(prev);
                        if(prev.val < curr.val && prev.val < prevPrev.val) arr.add(prev);
                    }
                    else if(prev != null && prev.val > curr.val) arr.add(prev);
                    prevPrev = prev;
                    prev = curr;
                    curr = curr.right;
                }
            }
            else { 
                //visit
                if(prev != null && prevPrev != null) {
                    if(prev.val > curr.val && prev.val > prevPrev.val) arr.add(prev);
                    if(prev.val < curr.val && prev.val < prevPrev.val) arr.add(prev);
                }
                else if(prev != null && prev.val > curr.val) arr.add(prev);
                prevPrev = prev;
                prev = curr;
                curr = curr.right;
            }
        }
        if(prev.val < prevPrev.val) arr.add(prev);
        TreeNode a = arr.get(0);
        TreeNode b = arr.get(arr.size()-1);
        int temp = a.val;
        a.val = b.val;
        b.val = temp;

    }
}