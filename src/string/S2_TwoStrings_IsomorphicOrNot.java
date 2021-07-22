package string;

import java.util.HashMap;

// https://leetcode.com/problems/isomorphic-strings/
/*
        abc -> xyz
        paper
        p = 2
        a = 1
        e = 1
        r = 1
 */
public class S2_TwoStrings_IsomorphicOrNot {
    public static void main(String[] args) {

    }
    // Character to character mapping
    // a b b => c a c
    // a b => a a
    // a is already used to map. Therefore you cannot use character to character mapping
    // Therefore you need to do 1 : 1 mapping
    // Bi-directional mapping
    // a -> a | a -> a
    // b -> a | a -> b
    /*
    String 1:              A B E A C D B
    index pattern:         0 1 2 0 4 5 1
    String 2:              X Y I X H K Y
    index pattern:         0 1 2 0 4 5 1
    HashMap
    a 0
    b 1
    e 2
    a 0
    c 4
    d 5

    Bi-directional mapping
    a b
    a a
    a -> b
    One to one mapping, not one to many mapping
    Character vs Character
     */
    static boolean isTwoStringsIsomorphic(String s, String t){
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> mapS = new HashMap<>();
        HashMap<Character, Integer> mapT = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            int indexS = mapS.getOrDefault(s.charAt(i), -1);
            int indexT = mapT.getOrDefault(t.charAt(i), -1);
            if (indexS != indexT) return false;
            mapS.put(s.charAt(i), i);
            mapT.put(t.charAt(i), i);
        }
        return true;
    }

    static boolean isTwoStringsIsomorphicAnother(String s, String t){
        HashMap<Character, Character> mapS = new HashMap<>();
        HashMap<Character, Boolean> mapT = new HashMap<>();

        for(int i =0; i < s.length(); i++){
            char sC = s.charAt(i);
            char tC = t.charAt(i);
            if (mapS.containsKey(sC) == true){
                if (mapS.get(sC) != tC){
                    return false;
                }
            } else {
                if (mapT.containsKey(tC) == true){
                    return false;
                } else {
                    mapS.put(sC, tC);
                    mapT.put(tC, true);
                }
            }
        }
        return true;
    }
}
