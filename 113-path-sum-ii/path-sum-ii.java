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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> arr = new ArrayList<>();
        helper(root,targetSum,ans,arr); 
        return ans;
    }
    public void helper(TreeNode root, int targetSum,List<List<Integer>> ans,List<Integer> arr) {
        if(root == null) return;
        if(root != null && root.left == null && root.right == null){
            arr.add(root.val);
            if(root.val == targetSum) {
                List<Integer> a = new ArrayList<>();
                for(int i = 0;i < arr.size();i++){
                    a.add(arr.get(i));
                }
                ans.add(a);
            }
            arr.remove(arr.size()-1);
            return;
        }
        arr.add(root.val);
        helper(root.left,targetSum-root.val,ans,arr);
        helper(root.right,targetSum-root.val,ans,arr);
        arr.remove(arr.size()-1); //backtrack;
    }
}