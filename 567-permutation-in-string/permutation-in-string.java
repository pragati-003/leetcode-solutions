class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if( s1.length() > s2.length()){
            return false;
        }

        int[] freq = new int[26];

        for(char ch : s1.toCharArray()){
            freq[ch - 'a']++;
        }

        int left = 0;
        for( int right = 0; right < s2.length(); right++){
            
            freq[s2.charAt(right) - 'a']--;

            if(right - left + 1 > s1.length()){
                freq[s2.charAt(left) - 'a']++;
                left++;
            }

            if(right - left + 1 == s1.length()){
                boolean found = true;

                for(int i = 0;i<26;i++){
                    if(freq[i] != 0) {
                        found = false;
                        break;
                    }
                }

                if(found) 
                    return true;
            }
        }
        return false;
    }
}