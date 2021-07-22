package hashing;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class lc_819_MostCommonWord {
    public static void main(String[] args) {
        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};
        System.out.println(mostCommonWord(paragraph, banned));
        System.out.println(mostCommonWord1(paragraph, banned));
    }

    public static String mostCommonWord(String paragraph, String[] banned) {
        // Convert every words into lower case
        paragraph = paragraph.toLowerCase();
        String paragraphModified = "";
        // To remove all other symbols "!?',;."
        for(int i =0; i < paragraph.length(); i++){
            char currentCharacter = paragraph.charAt(i);
            if (currentCharacter >= 'a' && currentCharacter <= 'z'){
                paragraphModified += currentCharacter;
            } else{
                paragraphModified+= " ";
            }
        }
        paragraph = paragraphModified;
        // Break string into words and break at space
        StringTokenizer st = new StringTokenizer(paragraph, " ");
        // Words map to frequency
        HashMap<String, Integer> map = new HashMap<>();
        while(st.hasMoreTokens()){
            // if you only do map.get(word), you will have a NullPointerException in Java
            // To prevent this error, use getOrDefault
            // if the word is not present, return 0.
            String word = st.nextToken();
            int newCount = map.getOrDefault(word, 0) + 1;
            map.put(word, newCount);
        }

        // Iterate over String array and look up in the map to remove banned words
        // This improves runtime
        for(String banWord : banned){
            map.remove(banWord);
        }

        // Check for the word with largest frequency
        String answer = "";
        int count = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            String word = entry.getKey();
            Integer frequency = entry.getValue();
            if (frequency > count){
                answer = word;
                count = frequency;
            }
        }
        return answer;
    }
/*
bob hit a ball the hit ball flew far after it was hit {the=1, a=1, ball=2, hit=3, bob=1, far=1, flew=1, was=1, after=1, it=1}


"Bob hit a ball, the hit BALL flew far after it was hit."
["hit"]

{the=1, a=1, ball=2, bob=1, far=1, flew=1, was=1, after=1, it=1}

 */
    public static String mostCommonWord1(String paragraph, String[] banned){
        String[] words = paragraph.toLowerCase().split("[ !?',;.]");
        HashMap<String, Integer> map = new HashMap<>();
        for(String word : words) map.put(word, map.getOrDefault(word, 0) + 1);
        for(String word : banned) if(map.containsKey(word)) map.remove(word);
        String res = null;
        for(String word : map.keySet())
            if(res == null || map.get(word) > map.get(res))
                res = word;
        return res;
    }
}
