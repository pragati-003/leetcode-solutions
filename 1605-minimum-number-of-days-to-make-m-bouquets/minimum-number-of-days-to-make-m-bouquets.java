class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m * k > bloomDay.length){
            return -1;
        }

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        for(int bloom : bloomDay){
            low = Math.min(low,bloom);
            high = Math.max(high,bloom);
        }

        while(low<=high){
            int mid = low + (high - low)/2;

            if(canMakeBloom(bloomDay,m,k,mid)){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return low;

    }
    private boolean canMakeBloom(int[] bloomDay,int m, int k, int day){
        int flowers = 0;
        int bouquets = 0;

        for(int bloom : bloomDay){
            if(bloom <= day){
                flowers++;

                if(flowers == k){
                    bouquets++;
                    flowers = 0;

                    if(bouquets == m){
                        return true;
                    }
                }
            }
            else{
                flowers = 0;
            }
        }
        return false;
    }
}