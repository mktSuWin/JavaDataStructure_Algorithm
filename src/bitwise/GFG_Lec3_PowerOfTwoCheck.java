package bitwise;

public class GFG_Lec3_PowerOfTwoCheck {
    public static void main(String[] args) {
        System.out.println(numOfBits(4));
        System.out.println(numOfBitsBrianKerningang(9));

        int num = Integer.parseInt("1001101110", 2);
        int[] lookupTable = new int[1<< 8];
        for(int i = 1; i < lookupTable.length; i++){
            lookupTable[i] = lookupTable[i >>1] + (i & 1);
        }
        // 0-7, 8-15, 16-25, 24-31
        int buck1 = extractSegment(num, 0, 7);
        int buck2 = extractSegment(num, 8, 15);
        int buck3 = extractSegment(num, 16,25);
        int buck4 = extractSegment(num, 26, 31);

        int count = lookupTable[buck1] + lookupTable[buck2] + lookupTable[buck3]+ lookupTable[buck4];
        System.out.println(count);
//        int l = 5, r = 7;
//        int segment = extractSegment(num, l, r);
//        System.out.println(Integer.toBinaryString(segment));
    }

    // right shift by 1
    // Number of bits
    // O(32)
    // 10011001
    public static boolean isNumPowerOfTwo(int num){
        //
        return true;
    }

    // 1010 - right shift
    // keep doing right shift
    // Time O(32) maximum
    // Simple Method
    public static int numOfBits(int num){
        int count = 0;
        while (num > 0){
            int bit = num & 1;
            if (bit == 1){
                count++;
            }
            num = num>>1;
        }
        return count;
    }

    // O(number of set bits)
    // 0    1   1   1
    // 0    1   1   0 = temp is num -1
    // --------------------------------
    // 0    1   1   0   & AND operation 6
    //--------------------------------- End of first iteration


    // 0    1   1   0
    // 0    1   0   1
    // --------------------------
    // 0    1   0   0 AND operation
    //

    public static  int numOfBitsBrianKerningang(int num){
        int count = 0;
        while (num > 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }

    // precompute lookup table
    // hash
    /*
    1   0   0   1   1   1   0   0   0   1   1

     */
    public static  int numOfBitsLookup(int num){
        int count = 0;
        while (num > 0){
            num = num & (num-1);
            count++;
        }
        return count;
    }

    public static int extractSegment(int num, int l, int r){
        int bits = r - l + 1; // 5-3+1 = 3
        int temp = (1 << bits)-1;
        int mask =temp<<1;
        int segment = num & mask;
        segment  =segment >>1;
        return segment;
    }

    public boolean isPowerOfTwo(int n){
        int count =0;
        if (n < 0) return false;
        while (n != 0){
            n = n & (n-1);
            count++;
        }
        return (count ==0);
    }

    public boolean isPowerOfTwo1(int n){
        if (n==0) return false;
        long a = (long) n;
        return (a & (a-1)) == 0;
    }
    /*
    To avoid overflow, convert int to long. If you don't want to convert it to long, add condition n< 0, return false;
     */
    public boolean isPowerOfTwo2(int n){
        if (n <= 0) return  false;
        return ((n-1)&n) == 0;
    }
    /*
    NOTE: If n > 0 is not in the condition, it will give you incorrect answer.
     */



}
