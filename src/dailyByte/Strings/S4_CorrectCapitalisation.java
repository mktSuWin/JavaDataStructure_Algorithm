package dailyByte.Strings;

public class S4_CorrectCapitalisation {
    public static void main(String[] args) {
        String s = "Computer";
        String s1 = "ComPuTer";
        System.out.println(correctCapitalisation(s));
        System.out.println(correctCapitalisation(s1));
    }

    public static boolean correctCapitalisation(String s){
        int count = 0;
        for (int i = 0; i < s.length() ; i++){
            if(Character.isUpperCase(s.charAt(i))){
                count++;
            }
        }
        return count == s.length() || count ==0 || count == 1 && Character.isUpperCase(s.charAt(0));
    }
}
