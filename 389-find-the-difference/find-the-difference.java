class Solution {
    public char findTheDifference(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n == 0 ){
            return t.charAt(0);
        }

        int[]freq = new int[256];

        for(int i = 0;i<m;i++){
            freq[t.charAt(i)]++;
            if(i<n) freq[s.charAt(i)]--;
        }

        char ans = ' ';
        for(int i = 0;i < m;i++){
            if(freq[t.charAt(i)] == 1){
                ans = t.charAt(i);
            }
        }
        return ans;
    }
}