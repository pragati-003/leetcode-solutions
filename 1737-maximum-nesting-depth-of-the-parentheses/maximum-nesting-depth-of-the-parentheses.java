class Solution {
    public int maxDepth(String s) {
        if(s.length() <=1){
            return 0;
        }

        int depth = 0;
        int max = 0;
        for(int i = 0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch == '('){
                depth++;
                max = Math.max(max, depth);
            }else if(ch == ')'){
                depth--;
            }
            
        }
        return max;
    }
}