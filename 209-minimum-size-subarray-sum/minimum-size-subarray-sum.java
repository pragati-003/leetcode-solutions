class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int currSum = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0;right < nums.length;right++){
            
            currSum += nums[right];

            while(currSum >= target){
                minLength = Math.min(minLength, right- left +1);
                currSum -= nums[left];
                left++;
            }
        }

        if(minLength == Integer.MAX_VALUE) 
           return 0;

        return minLength;
    }
}