package lc_contest;

public class lc_5778_MinFlipTomakeBinaryStringAlternating {
    public static void main(String[] args) {
        String s = "111000";
        System.out.println(minFlips(s));
    }

    public static int minFlips(String s) {
        int result = 0;
        for(int i = 0; i < s.length(); i++){
            if (s.charAt(i)  - '0' != i % 2){
                result++;
            }
        }
        return Math.min(result, s.length()-result);
    }
}
