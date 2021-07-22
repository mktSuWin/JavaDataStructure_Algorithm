package cb_CPMSoc;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class GFG_Lec2_Leaders_In_Array {
    public static void main(String[] args) {
        List<Integer> nums =  new ArrayList<>();
        nums.add(16);
        nums.add(17);
        nums.add(4);
        nums.add(3);
        nums.add(5);
        nums.add(2);
        System.out.println(leadersInArrayOptimised(nums));


    }
    public static List<Integer> leadersInArray(List<Integer> a){
        List<Integer> result = new ArrayList<>();
        int n = a.size();
        for(int i = 0; i < n; i++){
            boolean flag = true;
            for(int j = i + 1; j < n; j++){
                if (a.get(j) >= a.get(i)){
                    flag= false;
                    break;
                }
            }
            if (flag == true){
                result.add(a.get(i));
            }
        }

        return result;
    }

    /*
            16, 17, 4, 3, 5, 2
            2 is max till now.
            5 > 2, therefore, add 2 to result
            maxTillNow is 5.        2, 5,
            3 > 5, now. move on
            4 > 5 , no. move on
            17 > 5, yes, 2, 5, 17,
            16 > 17

            //-----------------------------------------------
            10  9   8   7   5   4   3   2   1   100
            10 > 9 , until end, 10 < 100, 10 is not a leader
            9 > 8....until 9 < 100, therefore 9 is not a leader
            maxTillNow
            Add 100 to result
            1 > 100 , no, do not add it to the result
            compare 2 with max.
     */
    public static List<Integer> leadersInArrayOptimised(List<Integer> a){
        ArrayList<Integer> result = new ArrayList<>();
        int n = a.size();
        int maxTillNow = a.get(n-1);
        result.add(a.get(n-1));
        for(int i = n-2;i >= 0; i++){
            if (a.get(i) > maxTillNow){
                maxTillNow = a.get(i);
                result.add(a.get(i));
            }
        }
        return result;
    }
}
