package dailyByte.Strings;

public class S5_addBinary {
    public static void main(String[] args) {
        String a = "1";
        String b = "111";
        System.out.println(addBinary(a,b));
    }
    // 0001 reversed
    public static String addBinary(String a, String b){
        StringBuilder result = new StringBuilder();
        int i = a.length()-1;
        int j = b.length()-1;
        int carry = 0;
        int len = Math.max(i,j);
        while(i >=0 || j >= 0){
            int sum = carry;
            if (i >= 0){
                sum += a.charAt(i--) - '0';
            }
            if(j >= 0){
                sum += b.codePointAt(j--) -'0';
            }
            result.append(sum %2);
            carry = sum / 2;
        }
        if (carry != 0){
            result.append(carry);
        }
        return result.reverse().toString();
    }

}
