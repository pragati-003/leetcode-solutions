/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private Map<Integer, Integer> inorderMap;
    private int[] postOrder;
    private int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postOrder = postorder;
        postIndex = postorder.length - 1;

        inorderMap = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i],i);
        }
        return helper(0,inorder.length);
    }
    public TreeNode helper(int iLeft,int iRight){
        if(iLeft >= iRight) return null;

        int val = postOrder[postIndex--];
        TreeNode root = new TreeNode(val);

        int mid = inorderMap.get(root.val);

        root.right = helper(mid+1,iRight);
        root.left  = helper(iLeft,mid);

        return root;
    }
}