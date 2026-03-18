class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> ans = new ArrayList<>();

        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num , 0) + 1);
        }

        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            if(entry.getValue() > (n/3)){
                ans.add(entry.getKey());
            }
        }
        return ans;
    }
}