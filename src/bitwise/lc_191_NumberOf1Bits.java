package bitwise;

public class lc_191_NumberOf1Bits {
    public static void main(String[] args) {
        int n = -2;
        System.out.println(hammingWeight(n));
    }
    /*
    Since it is
    Most significant bit 1
    in C++, there is unsigned int, therefore, it is correct.
    In java, it is
     */
    public static int hammingWeight(int n) {
        int count = 0;
        while (n > 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    public static int hammingWeightJava(int n) {
        int count = 0;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return count;
    }
    /*
    2^3     2^2     2^1     2^0
    0       1       0       1       = 5
    0       1       0       0       = 4 &
    0       1       0       0       = count 1

    2^3     2^2     2^1     2^0
    0       1       0       0       = 4
    0       0       1       1       = 3 &
    0       0       0       0       = count 2 and n is zero.

     */


        // you need to treat n as an unsigned value
        public int hammingWeight1(int n) {
            int result =0;
            while (n != 0){
                n = n & (n-1);
                result++;
            }
            return result;
        }

    /*
    2^3     2^2     2^1     2^0
    0       1       0       1       = 5
                            1
                            >>>
    0       0       1       0        = count 1


    2^3     2^2     2^1     2^0
    0       0       1       0
                            1
                            >>>
    0       0       0       1        = count 1


    2^3     2^2     2^1     2^0
    0       0       0       1
                            1
                            >>>
    0       0       0       0        = count 2
     */
    public int hammingWeight2(int n) {
        int count = 0;
        while (n !=0){
            count += (n &1);
            n>>>=1;
        }
        return count;
    }

    /*
    2^31 ....         2^3     2^2     2^1     2^0
    0                   0       1       0       1      n =5
                                                1 &    mask
    0                   0       0       0       1       count =1

    2^31 ....         2^3     2^2     2^1     2^0
    0                   0       1       0       1      n =5
                                        1       0  &   mask
    0                   0       0       0       1      count =1

    2^31 ....         2^3     2^2     2^1     2^0
    0                   0       1       0       1      n =5
                                1       0       0  &   mask
    0                   0       0       0       1      count =2
     */
    public int hammingWeight3(int n) {
        int count = 0;
        int mask = 1;
        for (int i =0; i < 32; i++) {
            if ((n & mask) != 0){
                count++;
            }
            mask <<= 1;

        }
        return count;
    }
}
