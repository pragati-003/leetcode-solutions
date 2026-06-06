class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backtrack("", n,0,0, ans);

        return ans;
    }

    private void backtrack(String s, int n ,int open, int close, List<String> ans){
        //base case
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }

        if(open < n){
            backtrack(s+"(",n,open+1,close,ans);
        }

        if(close<open){
            backtrack(s+")",n,open,close+1,ans);
        }
    }
}