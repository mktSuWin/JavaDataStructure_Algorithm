package dailyByte.Strings;

public class S3_isPalindrome {
    public static void main(String[] args) {
        String s = "level";
        String s1 = "algorithm";
        System.out.println(isPalindrome(s1));

        char c = 'C';
        char d = '/';
        boolean boolc = Character.isLetterOrDigit(c);
        System.out.println(c + " is a letter or digit ? " + boolc);

        boolean boold = Character.isLetterOrDigit(d);
        System.out.println(d + " is a letter or digit ? " + boold);

    }

    public static boolean isPalindrome(String s){
        s = s.toLowerCase();
        int i =0;
        int j = s.length()-1;
        while (i < j ){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(s.charAt(i++) != s.charAt(j--)){
                return false;
            }
        }
        return true;
    }
}
