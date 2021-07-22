package cb_CPMSoc;

import java.util.ArrayList;
import java.util.List;

public class GFG_Lec1_Searching {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 20, 34, 5, 6, -100};
        int[] sorted = new int[]{-100, 5, 6, 10, 20, 34};
        int n = sorted.length, k = -30;
//        System.out.println(binarySearch(sorted, n, k));

    }
    // Binary Search
    /*
    public static boolean binarySearch(int[] sorted, int n, int k){
        int left = 0, right = n-1;
        while (true){
            int mid = (left + right) /2;
            if (left ==  mid || left == right -1){
                if (sorted[left] == k){
                    return true;
                } else if (sorted[right] == k){
                    return true;
                } else
                    return false;
            } else if (sorted[mid] > k){
                right = mid;
            } else {
                left = mid;
            }
        }
    }

     */

    public static void insertElement(int[] nums, int k){
        List<Integer> insertArray = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            insertArray.add(nums[i]);
        }
    }
}
