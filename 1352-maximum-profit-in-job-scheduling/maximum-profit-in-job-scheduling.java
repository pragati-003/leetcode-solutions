class Solution {
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;

        int[][] jobs = new int[n][3];

        for (int i = 0; i < n; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        // Sort by end time
        Arrays.sort(jobs, (a, b) -> a[1] - b[1]);

        int[] dp = new int[n];

        dp[0] = jobs[0][2];

        for (int i = 1; i < n; i++) {

            // Don't take current job
            int notTake = dp[i - 1];

            // Find last job whose endTime <= current startTime
            int j = binarySearch(jobs, i, jobs[i][0]);

            int take = jobs[i][2];

            if (j != -1) {
                take += dp[j];
            }

            dp[i] = Math.max(take, notTake);
        }

        return dp[n - 1];
    }

    private int binarySearch(int[][] jobs, int end, int start) {

        int low = 0;
        int high = end - 1;
        int ans = -1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (jobs[mid][1] <= start) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}