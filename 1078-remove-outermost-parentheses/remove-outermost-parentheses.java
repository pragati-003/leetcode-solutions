class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int deapth = 0;

        for(char ch : s.toCharArray()) {
            if(ch == '(') {
                
                if(deapth > 0){
                    sb.append(ch);
                }
                deapth++;
            } else { //ch ===')'
             
                deapth--;
                if(deapth > 0){
                    sb.append(ch);
                }
            }
        } 
        return sb.toString();
    }
}