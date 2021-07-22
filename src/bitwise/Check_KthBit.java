package bitwise;

public class Check_KthBit {
    public static void main(String[] args) {

    }
    /*
    Use left shift and check
                c
        1   0   1   1   0   1   1
            1   0   1   1   0   1

    3   2   1   0
    0   1   1   1
    temporary 1 << k
    1   0    0  0
    1 << k
 AND


    Use right shift and check
                     c
                           k=3
         1  0   1   1   1   0   0   0   1   = num
         take num and right right k times
                1   0   1   1   1   0   0
          AND                           1
          if it is 1, it is set.


         


     */
    public static void checkKthBit(int n){
        // crate a number left shift to
    }
}
