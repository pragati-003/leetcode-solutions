class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z ]", " ");;

        HashMap<String, Integer> map = new HashMap<>();

        for(String s : paragraph.split("\\s+")){
            map.put(s, map.getOrDefault(s , 0)+1);
        }

        HashSet<String> set = new HashSet<>();


        for(String s : banned){
            set.add(s);
        }

        int max = 0;
        String ans = "";

        for(String s : map.keySet()){
            if(!set.contains(s) && map.get(s) > max){
                max = map.get(s);
                ans = s;
            }
        }
        return ans;
    }
}