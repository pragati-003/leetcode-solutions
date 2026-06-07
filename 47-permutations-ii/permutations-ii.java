class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
         List<List<Integer>> ans = new ArrayList<>(); // mandatory
        helper(nums,0,ans);
        return ans;
    }

    public void helper(int[] nums, int idx, List<List<Integer>> ans) {

        int n = nums.length;

        if(idx == n){
            List<Integer> l = new ArrayList<>();
            for(int num : nums){
                l.add(num);
            }
        ans.add(l);
        return;
        }   

        HashSet<Integer> used = new HashSet<>();

        for(int i = idx; i < n; i++){

            if(used.contains(nums[i]))
                continue;

            used.add(nums[i]);

            swap(i, idx, nums);
            helper(nums, idx + 1, ans);
            swap(i, idx, nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}