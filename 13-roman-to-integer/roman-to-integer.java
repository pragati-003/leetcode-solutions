class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> romanVal = new HashMap<>();
        romanVal.put('I',1);
        romanVal.put('V',5);
        romanVal.put('X',10);
        romanVal.put('L',50);
        romanVal.put('C',100);
        romanVal.put('D',500);
        romanVal.put('M',1000);

        int total = 0;
        int n = s.length();

        for(int i = 0;i<n;i++){
            int currVal = romanVal.get(s.charAt(i));

            if(i < n - 1  && currVal < romanVal.get(s.charAt(i+1))){
                total -= currVal;
            }else{
                total += currVal;
            }
        }
        return total;
    }
}