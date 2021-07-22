package cb_CPMSoc;
/*
Prefix Sum
 */
public class GFG_Lec2_prefixSum {
    public static void main(String[] args) {
        // index      0  1  2     3   4  5  6  7
        int[] nums = {8, 9, 14, -20, 17, 5, 6, 2};
//        System.out.println(sumArray(nums, 4, 7));
        int[] prefixSum = sumArrayOptimised(nums);
        for(int i : prefixSum){
            System.out.print(i + " ");
        }


    }
    // Time O(n*query)
    public static  int sumArray(int[] nums, int start, int end) {
        int sum = 0;
        for(int i = start; i <= end; i++){
            sum += nums[i];
        }
        return sum;
    }

    // Time O(n + q)
    // Space O(1)
    public static int[] sumArrayOptimised(int[] nums){
        int[] prefixSum = new int[nums.length];
        for(int i = 0; i < nums.length; i++){
            prefixSum[i] += nums[i];
        }
        return prefixSum;
    }
}
