class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int x = flowerbed.length;
        int count = 0;

        for(int i = 0;i < x;i++){
            if(flowerbed[i] == 0) {
                if((i == 0 || flowerbed[i-1] == 0) &&
                   (i == x-1 || flowerbed[i+1] == 0)) {

                    flowerbed[i] = 1;
                    count++;
                }
            }
        }

        return count >= n;
    }
}