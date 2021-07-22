package cb_CPMSoc;

public class GFG_Lec2_MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int[] nums1 = {-1, -2, -3 , -4, -5};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayOptimised(nums1));
    }

    public static int maxSubArray(int[] nums){
        int result = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int currSum = 0;
            for (int j = i; j < nums.length; j++){
                currSum += nums[j];
                result = Math.max(result, currSum);
            }
        }
        return result;
    }

    public static int maxSubArrayOptimised(int[] nums){
        int result = nums[0];
        int n = nums.length;
        // Kadane algorithm
        int sumTillNow = nums[0];
        for(int i = 0; i < n; i++){
            int a = nums[i];
            sumTillNow = Math.max(a, sumTillNow + a);
            result = Math.max(sumTillNow, result);
        }
        return result;
    }

    public static int maxSubArrayOptimised1(int[] nums){
        int result = nums[0];
        int currSum = nums[0];
        int n = nums.length;
        int start = 0;

        for(int end = 0; end < n; end++){
            currSum += nums[end];
            result = Math.max(currSum, result);
            while (currSum < 0){
                currSum -= nums[start];
                start++;
            }
        }
        return result;
    }
}
