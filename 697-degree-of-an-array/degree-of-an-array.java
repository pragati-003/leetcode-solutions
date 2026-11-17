class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, int[]> map = new HashMap<>();

        int degree = 0, ans = nums.length;

        for(int i = 0;i < nums.length;i++){
            int x = nums[i];

            freq.put(x,freq.getOrDefault(x,0)+1);

            if(!map.containsKey(x)) {
                map.put(x, new int[]{i, i});
            }else {
                map.get(x)[1] = i;
            }

            int f = freq.get(x);
            int len = map.get(x)[1] - map.get(x)[0] + 1;
            
            if(f > degree){
                degree = f;
                ans = len;
            }
            else if(f == degree) {
                ans = Math.min(ans, len);
            }
        }
        return ans;
    }
}