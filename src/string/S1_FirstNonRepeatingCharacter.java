package string;
// https://leetcode.com/problems/first-unique-character-in-a-string/
import java.util.HashMap;

public class S1_FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String s = "interviewbit";
        String s1 = "scalaracademy free classes";
        firstNonRepeatingCharactesr(s);

    }
    /*
    char[ ] = 26
    or
    char[ ] = 256
    HashMap
     */
    static void firstNonRepeatingCharactesr(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0)+1);
        }

        for(int i = 0 ; i < s.length(); i++){
            char c = s.charAt(i);
            if ((map.get(c)) ==1){
                System.out.println(c);
                break;
            }
        }
    }

    static int firstNonRepeatingCharWithArray(String s){
        int[] letters = new int[26];
        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i) -'a';
            letters[index]++;
        }

        for(int i = 0; i < s.length(); i++){
            int index = s.charAt(i);
            if (index == 1){
                return i;
            }
        }
        return -1;
    }
}
