package twoPointers;

public class lc_844_BackspaceStringCompare {
    public static void main(String[] args) {
        String s = "ab#c";
        String t = "ad#c";
        System.out.println(backspaceCompare(s,t));
    }

    public  static boolean backspaceCompare(String S, String T) {

        int s_pointer = S.length()-1;
        int t_pointer = T.length()-1;

        int s_skip = 0;
        int t_skip = 0;

        while(s_pointer >= 0 || t_pointer >= 0){
            // S String - sub loop
            while(s_pointer >= 0){
                if(S.charAt(s_pointer )== '#'){
                    s_skip ++;
                    s_pointer --;
                }else if(s_skip > 0){
                    s_pointer --;
                    s_skip --;
                }else{
                    break;
                }
            }

            // T-string sub loop
            while(t_pointer >= 0){
                if(T.charAt(t_pointer) == '#'){
                    t_skip ++;
                    t_pointer --;
                }else if(t_skip > 0){
                    t_pointer --;
                    t_skip --;
                }else{
                    break;
                }
            }

            if(s_pointer >= 0 && t_pointer>= 0 && S.charAt(s_pointer) != T.charAt(t_pointer)){
                return false;
            }

            if(s_pointer >= 0 != t_pointer >= 0){
                return false;
            }
            s_pointer --;
            t_pointer --;
        }
        return true;
    }
}
