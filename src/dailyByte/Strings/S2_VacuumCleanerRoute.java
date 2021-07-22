package dailyByte.Strings;

public class S2_VacuumCleanerRoute {
    public static void main(String[] args) {

    }
    // Time O(n)
    // Space O(1) constant
    public static boolean vacuumCleanerRoute(String moves){
        int UD = 0;
        int LR = 0;
        for(int i = 0; i < moves.length(); i++){
            char current = moves.charAt(i);
            switch (current){
                case 'U':
                    UD++;
                case 'D':
                    UD--;
                case 'L':
                    LR--;
                case 'R':
                    LR++;
            }
        }
        return UD == 0 && LR ==0;
    }
}
