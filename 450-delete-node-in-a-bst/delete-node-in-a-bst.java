class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } 
        else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } 
        else {
            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Both children exist
            TreeNode successor = root.right;

            // Find smallest node in right subtree
            while (successor.left != null) {
                successor = successor.left;
            }

            // Replace current value
            root.val = successor.val;

            // Delete successor
            root.right = deleteNode(root.right, successor.val);
        }

        return root;
    }
}