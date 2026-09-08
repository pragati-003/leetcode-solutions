class Solution {
    public TreeNode sortedListToBST(ListNode head) {
         //calculate len of linked list
         ListNode temp = head;
         int n = 0;
         while(temp != null){
            n++;
            temp = temp.next;
        }
        int[] arr = new int[n];
        int i = 0;
        temp = head;
        while(temp != null){
            arr[i] = temp.val;
            i++;
            temp = temp.next;
        }
        return helper(arr,0,n-1);
    }

    private TreeNode helper(int[] arr, int i, int j){
        if(i>j) return null;

        int mid = i + (j-i)/2;
        TreeNode root = new TreeNode(arr[mid]);
        root.left = helper(arr,i,mid-1);
        root.right = helper(arr,mid+1,j);
        return root;
    }
}