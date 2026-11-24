class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        String[] morse = {
            ".-", "-...", "-.-.", "-..", ".", "..-.",
            "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.",
            "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."
        };

        HashSet<String> set = new HashSet<>();

        for(String word : words){

            StringBuilder sb = new StringBuilder();

            for(int i = 0;i < word.length();i++){

                int index = word.charAt(i) - 'a';

                sb.append(morse[index]);
            }
            set.add(sb.toString());
        }
        return set.size();
    }
}