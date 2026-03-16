class Solution {
    public String removeOuterParentheses(String s) {
        int n = s.length();
        String ans = "";
        int countOpenBrace = 0;
        for(int i = 0; i < n; i++){
            if(countOpenBrace > 0 && !(countOpenBrace == 1 && s.charAt(i) == ')')) ans += s.charAt(i);
            if(s.charAt(i) == '(') countOpenBrace++;
            else countOpenBrace--;
        }

        return ans;
    }
}