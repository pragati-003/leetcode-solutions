class Solution {
    public int mostFrequentEven(int[] nums) {
        int n = nums.length;

        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            if(num%2 == 0){
            freq.put(num, freq.getOrDefault(num , 0) + 1);
            }
        }

        int maxVal = 0;
        int ans = Integer.MAX_VALUE;

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int num = entry.getKey();
            int count = entry.getValue();

            if(count > maxVal || (count == maxVal && num<ans)){
                maxVal = count;
                ans = num;
            }
        }
        return maxVal == 0 ? -1:ans;
    }
}