class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];

        // count magazine letters
        for (char ch : magazine.toCharArray()) {
            freq[ch - 'a']++;
        }

        // use letters for ransomNote
        for (char ch : ransomNote.toCharArray()) {
            if (freq[ch - 'a'] == 0) {
                return false;
            }
            freq[ch - 'a']--;
        }

        return true;
    }
}