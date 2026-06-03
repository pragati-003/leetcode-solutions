class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>() ,ans);

        return ans;
    }

    public void backtrack(int idx,int target,int[] candidates, List<Integer> curr, List<List<Integer>> ans){
        //base case
        if(target == 0){
            ans.add(new ArrayList<>(curr));
            return;
        }

        if(idx == candidates.length || target < 0){
            return;
        }

        //pick current element
        curr.add(candidates[idx]);
        backtrack(idx, target - candidates[idx],candidates,curr,ans);
        
        //backtrack
        curr.remove(curr.size() - 1);

        //pick new element
        backtrack(idx+1, target, candidates,curr,ans);
    }
}