class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> val = new Stack<>();

        for(int i = 0;i<tokens.length;i++){
            String token = tokens[i];
            if(token.equals("+") || token.equals("-") ||
                token.equals("*") || token.equals("/")){
                
                int v2 = val.pop();
                int v1 = val.pop();
                if(token.equals("+")) val.push(v1+v2);
                if(token.equals("-")) val.push(v1-v2);
                if(token.equals("*")) val.push(v1*v2);
                if(token.equals("/")) val.push(v1/v2);
            }
            else{
                val.push(Integer.parseInt(token));
            }
        }
        return val.peek();
    }
}