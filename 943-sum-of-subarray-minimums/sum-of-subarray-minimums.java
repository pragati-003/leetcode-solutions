class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;

        long[] dp = new long[n];

        long ans = 0;
        Stack<Integer> st = new Stack<>();

        int MOD = 1_000_000_007;

        for(int i = 0;i < n; i++){
            
            while(!st.isEmpty() && arr[st.peek()] > arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                dp[i] = (long) arr[i] * (i+1);
            }else{
                int prev = st.peek();

                dp[i] = dp[prev] + (long) arr[i] * (i - prev);
            }

            st.push(i);
            
            ans = (ans + dp[i]) % MOD;
        }
        return (int) ans;
    }
}