class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        HashMap<Character,Integer> map = new HashMap<>();

        for(char ch : licensePlate.toCharArray()){

            if(Character.isLetter(ch)){
                ch = Character.toLowerCase(ch);
                map.put(ch, map.getOrDefault(ch,0)+1);
            }
        }

        String ans = "";
        int min = Integer.MAX_VALUE;

        for(String word : words){
            if(word.length() >= min){
                continue;
            }

            HashMap<Character,Integer> freq = new HashMap<>();

            for(char ch : word.toCharArray()){
                freq.put(ch, freq.getOrDefault(ch, 0)+1);
            }

            boolean valid = true;

            for(char ch : map.keySet()){

                if(freq.getOrDefault(ch, 0) < map.get(ch)){
                    valid = false;
                    break;
                }
            }

            if(valid){
                min = word.length();
                ans = word;
            }
        }
        return ans;
    }
}