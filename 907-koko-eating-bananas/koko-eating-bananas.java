class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxPile = 0;
        for(int pile : piles){
            if(maxPile<pile){
                maxPile = pile;
            }
        }

        int low = 1, high = maxPile;
        int ans = maxPile;

        while(low <= high){
            int mid = low + (high-low)/2;
            long totalH = calculateHour(piles,mid);

            if(totalH <= h){
                ans = mid;
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return ans;
    }

    public long calculateHour(int[] piles, int speed){
        long totalH = 0;
        for(int pile : piles){
            totalH  += (int)Math.ceil((double)pile/speed);
        }
        return totalH;
    }
}