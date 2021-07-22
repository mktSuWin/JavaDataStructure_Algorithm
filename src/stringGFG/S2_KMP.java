package stringGFG;

public class S2_KMP {
    public static void main(String[] args) {
        String s = "abcabcadb";
        String pattern = "abcd";
    }

    /*
    Naive Approach
    =========================
         V
    s = abcabcadb
        ----
        V
    p = abcd
    Compare each letter and move both pointers simultaneously
    pattern = abcd
    // Start from 10:21
    for( start in range (0, n-1) {
        for(k in range (m){
            check if (start+k) == p(k)
                move on
            else
                break

    abcabcadb
     */
    /*
        a   a   a   a   a   a   b   => string
        a   a   b                   => pattern
        (n - m + 1)m
            Time: n x m
            s.length() * pattern.length()
     */
    static boolean subString(String s, String pattern){
        for(int i = 0; i < s.length(); i++){
            for(int k = 0;  k < pattern.length(); k++){
                if (s.charAt(i+k) == pattern.charAt(k)){
                    continue;
                } else{
                    break;
                }
            }
        }
        return true;
    }

    /*
    Take a string
    lps : longest proper prefix = proper prefix
    a   b   a   b   d - pattern
    a                 - prefixes
    a   b
    a   b   a
    a   b   a   b
    a   b   a   b   d


    0   1   2   3   4   5   6   7   - Index of LPS
 len0
    a   b   a   b   b   a   b   c
    0   0   1   2





     */
    static String KMP(String s){
        return s;
    }
}
