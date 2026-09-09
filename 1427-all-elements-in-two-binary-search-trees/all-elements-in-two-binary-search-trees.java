class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> a = new ArrayList<>(); // root1 ke sare elements in sorted order

        TreeNode curr = root1;
        while(curr != null){
            if(curr.left != null) {  // find pred
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) pred = pred.right;
                if(pred.right == null){ // connect pred to curr
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){
                    pred.right = null;
                    a.add(curr.val);
                    curr = curr.right;
                }
            }
            else{ // if curr left doesnt exist
                a.add(curr.val);
                curr = curr.right;
            }
        }

        List<Integer> b = new ArrayList<>(); // root1 ke sare elements in sorted order

        curr = root2;
        while(curr != null){
            if(curr.left != null) {  // find pred
                TreeNode pred = curr.left;
                while(pred.right != null && pred.right != curr) pred = pred.right;
                if(pred.right == null){ // connect pred to curr
                    pred.right = curr;
                    curr = curr.left;
                }
                if(pred.right == curr){
                    pred.right = null;
                    b.add(curr.val);
                    curr = curr.right;
                }
            }
            else{ // if curr left doesnt exist
                b.add(curr.val);
                curr = curr.right;
            }
        }

        List<Integer> ans = new ArrayList<>();
        merge(a,b,ans);
        return ans;
    }

    public void merge(List<Integer> a,List<Integer> b,List<Integer> ans) {
        int i = 0;
        int j = 0;

        while(i<a.size() && j<b.size()) {
            if(a.get(i) <= b.get(j)){
                ans.add(a.get(i));
                i++;
            }else{
                ans.add(b.get(j));
                j++;
            }
        }

        if(i == a.size()){
            while(j<b.size()){
                ans.add(b.get(j));
                j++;
            }
        }else{
            while(i<a.size()){
                ans.add(a.get(i));
                i++;
            }
        }
    }
}