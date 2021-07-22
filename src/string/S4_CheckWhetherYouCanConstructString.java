package string;
// Use HashMap if you see these
// first occurrence
// last occurrence
// frequency

/*
Given a string, check if you can construct
the given string by repeating any substring of its string
abc abc abc
--- --- ---
abc

ab ab ab ab ab = true

axybc = false

aaabbb
a = 3
b = 3

aaa
bbb
abc abc abc
abc abc bac

Two Pointers
Sliding Window
abba abba   abba

Circular string
a b c a b c a b c
a b c - multiple numbers of
Add the same string
a   b   a   b   a   b
if there exists such a string,
a b c d e f a b c d e f

abcabc - original string
abcabc abcabc - append itself to the end
- Find the original string in the new string
- remove first and last occurrences
- a1 a2 a3 a4 a5 a6 a1 a2 a3 a4 a5 a6
- a1 | a2 a3 a4 a5 a6 a1 a2 a3 a4 a5 | a6
-            a1 a2 a3 a4 a5 a6

It means that
        a4 = a1
        a5 = a2
        a6 = a3
        a1 = a4
        a2 = a3
        a3 = a6

        a4 a5 a6 = a1 a2 a3

  Examle
  abc bac abc bac
  a|bc bac abc ba|c
  abc bac

 s  = ac
 s' = a|ca|c
 ac
 c != a
 a != c

Grab a size of substring and test it out
Start from 1 characterint
p   p   p   p
---------
    ---------
    longest
 */
public class S4_CheckWhetherYouCanConstructString {
    public static void main(String[] args) {
        String s = "abcabcabcabc";
        System.out.println(repeatedSubstringPattern(s));

    }

    static boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for(int i = len/2; i >= 1; i--){
            if (len % i == 0){
                int num_repeats = len / i;
                String substring = s.substring(0, i);
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < num_repeats; j++){
                    sb.append(substring);
                }
                if (sb.toString().equals(s)){
                    return true;
                }
            }
        }
        return false;
    }
}
