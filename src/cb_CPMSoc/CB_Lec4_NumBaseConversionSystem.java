package cb_CPMSoc;
// https://leetcode.com/problems/base-7/
public class CB_Lec4_NumBaseConversionSystem {
    public static void main(String[] args) {
        int sourceBase = 10;
        int destinationBase = 7;
        int num = 100;
//        System.out.println(convertToBase(num, sourceBase, destinationBase));
        System.out.println(convertOneBaseToAnotherBase(101,8,10));
    }
    /*
        1           0           0
        1*10^2      0*10^1      0*10^0
        100         0           0
        remainder = 100 % 7 = 2
        ans = 0 + 2 * 1 = 2
        num = 100/7 = 14
        multiple = 1 * 10 = 10

        remainder = 14 % 7 = 2
        ans = 2 * 10 = 20
        num = 14/7 = 2;
        multiple = 10 * 10;

        remainder = 2% 7 = 2
        answer = 20 + 2 * 100 = 220
        multiple = 100 * 10 = 1000
        num = 2 / 7 = 0

        sourceBase          100
        destinationBase     7

        number              Quotient        remainder
        100/7               14              2 -----------last digit
        14/7                2               0
        2/7                 0               2 ----------- first digit

         202

        -7
        -7/7            -1              0
        -1/7            0               -1

        9
        2^3     2^2     2^1     2^0
        1        0       0        1
        1*10^3  + 0*10^2 + 0*10^1 + 1* 10^0
        1000    + 0      + 0      + 1 = 1001

        9/2                 4           1 *
        4/2                 2           0
        2/2                 1           0
        1/2                 0           1


     */
    public static String convertToBase(int num, int sourceBase, int destinationBase){
        int multipleFactor = 1;
        int ans =0;
        while (num != 0){
            int remainder = num % destinationBase;
            num /= destinationBase;
            ans += remainder * multipleFactor;
            multipleFactor *= sourceBase;
        }
        return String.valueOf(ans);
    }

    public String convertToBase7(int num) {
        int sourceBase = 10;
        int destinationBase = 7;
        int ans = 0;
        int multiple = 1;
        while (num != 0){
            int remainder = num % destinationBase;
            ans += (remainder * multiple);
            num /= destinationBase;
            multiple *= sourceBase;
        }
        return String.valueOf(ans);
    }

    public static String convertOneBaseToAnotherBase(int num, int sourceBase, int destinationBase){
            int ans = 0;
            int multiple = 1;
            while (num > 0){
                int remainder = num % destinationBase;
                num /= destinationBase;
                ans += (remainder * multiple);
                multiple *= sourceBase;
            }
            return String.valueOf(ans);

    }

}
