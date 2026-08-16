class Solution {
    public int shipWithinDays(int[] weights, int days) {
        
        int low = Arrays.stream(weights).max().getAsInt();;
        int high = Arrays.stream(weights).sum();

        while(low<=high){

            int mid = low + (high - low)/2;

            if(daysNeeded(weights,mid) <= days){
                high = mid - 1;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }

    private int daysNeeded(int[] weights, int capacity){
        int days = 1;
        int currentload = 0;
        for(int w : weights){
            if(currentload + w > capacity){
                days++;
                currentload = w;
            }else{
                currentload += w;
            }
        }
        return days;
    }
}