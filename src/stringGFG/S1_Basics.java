package stringGFG;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.*;

public class S1_Basics {
    public static void main(String[] args) {
        String s = "geeksforgeeks";
        // System.out.println(secondLowestRepeatedElements(s));
        String s1 = "AAABABAA", p = "AABA";
        anagramSubStringSearch(s1, p);

    }
    // https://www.geeksforgeeks.org/find-the-first-repeated-character-in-a-string/
    /*
                                                1   2   3
        0   1   2   3   4   5   6   7   8   9   0   0   0
        g   e   e  k    s   f   o   r   g   e   e   k   s"
        g   0   8
        e   0

        0   1   2   3   4   5   6   7   8   9
        h   e   l   l   o   w   o   r   l   d
        l
        second lowest occurrence
        h   0
        e   1
        l   2   3

        ----------------------------
        0   1   2   3   4   5
        a   b   c   a   b   c
        a   0   3
        b   1   4
        c   2   5

        Set data structure
        int[ ] array = new int[26];
        if come across, change array[i] = -1;
     */
    // Space O(n)
    // Time O(n)
    static int secondLowestRepeatedElements(String s){
        Set<Character> set = new HashSet<>();
        for(int i =0; i < s.length(); i++){
            char c = s.charAt(i);
            if(set.add(c) == false){
                return i;
            }
        }
        return -1;
    }

    static void secondLowestRepeatedElementsArray(String s){
        int[] letters = new int[26];
        for(int i =0; i < s.length(); i++){
            letters[i] = s.charAt(i) - 'a';
        }
    }
    /*
        c a b
        First find permutations of the string

        c   a   b
        c   b   a

        Recursive procedure
        c a b - remains at same position
        c b a - swap last two
        a c b
        a b c
        b a c
        b c a
        This is a maths problem
        10 characters
        10! permutation

        string -> all unique characters
        g   i   n   r   s   t  (sort the string)
        g   i   n   r   t   s
        g   i   n   s   r   t
        g   i   n

     */// https://www.geeksforgeeks.org/lexicographic-rank-of-a-string/
    static void lexicographicRankOfString(String s ){

    }

    /*
            0 1 2 3 4 5 6 7
            A A A B A B A A             A A B A

            A A A B = YES ANAGRAM 0
              A A B A = YES       1
                A B A B = NO
                  B A B A = NO
                    A B A A = YES 4

     */

    static void anagramSubStringSearch(String s, String pattern){
        int[] frequency = new int[26];
        int p1 = 0, p2 =0;
        for(int i =0; i < pattern.length(); i++){
            frequency[pattern.charAt(i) - 'A']--;
        }
        p2 = pattern.length()-1;
        for(int i = 0; i < pattern.length();i++){
            frequency[s.charAt(i) -'A']++;
        }
        List<Integer> ansIndexes = new ArrayList<>();

        while (true){
            if (helper_anagramSubStringSearch(frequency)){
                ansIndexes.add(p1);
            }
            p2++;
            if (p2== s.length()) break;
            frequency[s.charAt(p2) - 'A']++;
            frequency[s.charAt(p1) - 'A']--;
            p1++;
        }
        System.out.println(ansIndexes);
    }
    /*
    This is the window size
        p1        p2
        0          k
        1           k+1
        2           k+2
        3           k+3
        O(M (N - M))
        O(26. N)

     */
    //   O(26. N) , this helps with optimisation
    static boolean helper_anagramSubStringSearch(int[] frequency){

//        int[] allZeroes = new int[frequency.length];
//        return Arrays.equals(frequency, allZeroes);

        for(int i =0; i < frequency.length; i++){
            if (frequency[i] > 0) return false;
        }
        return true;
    }


    //
    public boolean rotateString(String s, String goal) {
        // Without any rotation, are they equal, Do we even need to do anything.
        if (s.equals(goal)) return true;
        for(int i = 0; i < s.length(); i++){
            String x = s.substring(0,1);
            String y = s.substring(1, s.length());
            String newString = y + x;

            if (newString.equals(goal)) return true;
            s = newString;
        }
        return false;
    }
}
