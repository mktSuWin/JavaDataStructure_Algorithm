package bitwise;

public class BitwiseExample {
    public static void main(String[] args) {
        int x = 5;
        int y = 1;
//        printPattern1(x);
//        String binary = Integer.toBinaryString(-2);
//        System.out.println(binary);
//        System.out.println(binary.length());
        // And operator
//        System.out.println(x&y);
//        System.out.println(x|y);
//        System.out.println((x^y));
        //==================================
//        String bin = Integer.toBinaryString(~10);
//        System.out.println(bin + " "+ bin.length());
//        System.out.println(~-10);
//        String bin = Integer.toBinaryString(-2);
//        System.out.println(bin + " "+ bin.length());
//        System.out.println(-2>>2);
        long p = 1;
        for(int i = 0; i <31; i++){
            p *= 2;
        }
        int num = (int) (p-1);
        System.out.println(num);
        num = -num;
        System.out.println(num);
        //num |= 1 << 30;
        //System.out.println(num);
        //System.out.println(num<<1);
        System.out.println(Integer.toBinaryString(num));
        String bin = Integer.toBinaryString(num<<1);
        System.out.println(bin + " "+ bin.length());

        num = num >> 1;
        System.out.println(num + " "+ bin(num));
    }
    public static String bin(int num){
        String bin = Integer.toBinaryString(num >> 1);
        while (bin.length() < 32)
            bin = "0" + bin;
        return bin;
    }


    public static void printPattern1(int n){
        int count = 1;
        for(int i = 0; i < n;i++){
            for(int j = 0; j <= i; j++){
                if ((i +j) % 2 == 0){
                    System.out.print("0");
                } else {
                    System.out.print("1");
                }
            }
            System.out.println();
        }
    }
}
/*
1
0   1
1   0   1
0   1   0   1
1   0   1   0   1
0   1   0   1   0   1
1   0   1   0   1   0   1

*/
