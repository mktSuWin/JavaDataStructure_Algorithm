package slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWith_K_Distinct_Characters {
    public static void main(String[] args) {
        String s = "AAAHHIBC";
        int k = 3;
        System.out.println(longestSubStringLengthWithKDistinctCharacters(s, k));
    }

    static int longestSubStringLengthWithKDistinctCharacters(String s, int k){
        int longestLen =0;
        int start = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end = 0; end < s.length(); end++){
            char c = s.charAt(end);
            map.put(c, map.getOrDefault(c, 0)+1);

            while(map.size() > k){
                char left = s.charAt(start);
                map.put(left, map.get(left) -1);
                if (map.get(left) == 0){
                    map.remove(left);
                }
                start++;
            }
            longestLen = Math.max(longestLen, end - start+1);
        }

        return longestLen;
    }
}
