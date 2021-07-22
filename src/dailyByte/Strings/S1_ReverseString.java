package dailyByte.Strings;

public class S1_ReverseString {
    public static void main(String[] args) {
        String s = "I love Japan";
        System.out.println(reverse(s));
    }

    public static String reverse(String s){
        String reversed = "";
        for(int i = s.length() -1; i >=0; i--){
            reversed += s.charAt(i);
        }
        return reversed;
    }

    public static String reverse1(String s){
        char[] charArray = new char[s.length()];
        int j =0;
        for(int i = s.length()-1; i >= 0; i--){
            charArray[j++] = s.charAt(i);
        }
        return new String(charArray);
    }
}
