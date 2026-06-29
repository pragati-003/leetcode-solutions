class Solution {
    static int[] dp;
    public int rob(int[] arr) {
        if (arr.length == 1) return arr[0];

        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int ans1 = loot1(1, arr);

        dp = new int[arr.length];
        Arrays.fill(dp, -1);
        int ans2 = loot2(0, arr);
        
        return Math.max(ans1, ans2);
    }

    private int loot1(int i, int[] arr){ 
        if(i>=arr.length) return 0;
        
        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + loot1(i+2,arr);
        int skip = loot1(i+1,arr);
        return dp[i] = Math.max(pick,skip);
    }

    private int loot2(int i, int[] arr){ 
        if(i>=arr.length-1) return 0;
        
        if(dp[i] != -1) return dp[i];

        int pick = arr[i] + loot2(i+2,arr);
        int skip = loot2(i+1,arr);
        return dp[i] = Math.max(pick,skip);
    }
}