package string;

import java.util.Stack;
// 1047. Remove All Adjacent Duplicates In String
public class S3_RemovePairsOfDuplicateChars {
    public static void main(String[] args) {
        String s = "abccd"; // abd
        String s1 = "abccbd"; // abbd // ad
        // You need to recursively remove the pairs
        String s2 = "abccba"; // abba // aa // empty string
        String s3 = "abbbg"; // abg , no pair of duplicate characters
    }
    /*
    Brute force approach
    =====================
    iterate through the strings multiple times and remove pairs one by one pair
     */
    static String removePairsOfDuplicateCharactesr(String s){
        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()){
            if (!stack.isEmpty() && stack.peek() == c){
                stack.pop();
            } else{
                stack.push(c);
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : stack){
            sb.append(s);
        }
        return sb.toString();
    }
}
