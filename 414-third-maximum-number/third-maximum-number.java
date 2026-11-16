class Solution {
    public int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE;
        long smax = Long.MIN_VALUE;
        long tmax = Long.MIN_VALUE;

        for(int num : nums){

            if(num == max || num == smax || num == tmax) continue;

            if(max < num){
                tmax = smax;
                smax = max;
                max = num;
            }
            else if(smax < num){
                tmax = smax;
                smax = num;
            }
            else if(tmax < num){
                tmax = num;
            }
        }

        return (int)(tmax == Long.MIN_VALUE?max:tmax);
    }
}