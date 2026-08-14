class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int total = 0;

        for (int x : nums) {
            total += x;
        }

        // Impossible target
        if (Math.abs(target) > total) {
            return 0;
        }

        // S1 - S2 = target
        // S1 + S2 = total
        // Therefore:
        // S1 = (total + target) / 2

        if ((total + target) % 2 != 0) {
            return 0;
        }

        int requiredSum = (total + target) / 2;

        int[] dp = new int[requiredSum + 1];

        dp[0] = 1;

        for (int num : nums) {

            for (int j = requiredSum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }

        return dp[requiredSum];
    }
}