class Solution {
    public int sumOfGoodIntegers(int n, int k) {
       int ans = 0;

       int st = Math.max(1, n-k);
       int end = n+k;
       for(int x = st ; x <= end;x++){
        if((n & x) == 0){
            ans += x;
        }
       } 
       return  ans;
    }
}