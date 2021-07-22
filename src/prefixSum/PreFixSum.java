package prefixSum;
/*
1. Equilibrium index in an array
2. Find if an array consists of subarray with 0 sum
3. Find count of subarray with an equal count of 0 and 1
4. Find the max length of subarray with equal number of 0 and 1
5. Find longest span with sum zeros into binary array of same length
 */
public class PreFixSum {
    public static void main(String[] args) {
        int[] nums = {-7, 1, 5, 2, -4, 3, 0};
        System.out.println(equilibriumIndexOfArray(nums));
    }
    /*
        8   1   5   7   8   9   12
     0  8   9   14  21  29  38  50
     Like memorisation - You don't have to calculate over and over again.
     It is like DP.
     PrefixSum algorithm
     -------------------
     */
    static void preFixSum(int[] nums){
        for(int i =1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }
        for(int i : nums){
            System.out.println(i);
        }
    }
    // 1. Equilibrium index in an array
    // -7   1   5   2   -4  3   0
    // first and last elements are impossible
    // sum of all elements on left hand side ==
    // sum of all elements on right hand side
    //                  leftSum      rightSum
    //if 1 is pivot         -7           6
    //if 5 is pivot         -6           1
    // if 2 is pivot        -1          -1
    static int equilibriumIndexOfArray(int[] nums){
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i] + nums[i-1];
        }

        int leftSum = nums[0];
        int rightSum = nums[nums.length-1];
        int left = 0;
        int right = nums.length-1;
        while (left < nums.length && right > 0){
            if (nums[left] == nums[right]){
                return left +1;
            } else {
                left++;
                right--;
            }
        }
        return -1;
    }

    /*
    Common span in the arrays, with equal numbers of 0s and 1s
    2.      1   0   1   1   0   1   0
            -----2
            0   1   0   1   1   0   0
            -----2
     */
    static int largestSpanInBinaryArrays(int[] nums1, int[] nums2){
        int countZ1 = 0, countZ2 = 0, countO1 = 0, countO2 = 0;
        for(int i = 0; i < nums1.length; i++){

        }
        return 0;
    }
}
