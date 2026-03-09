class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        if(n == 2 && nums[0] > 0){
            return nums;
        }

        int[] ans = new int[n];

        int posInd = 0;
        int negInd = 1;

        for(int num : nums){

            if(num>0){
                ans[posInd] = num;
                posInd += 2;
            }else{
                ans[negInd] = num;
                negInd += 2;
            }
            
        }

        return ans;
    }
}