package cb_CPMSoc;

public class GFG_Lec2_LongestAlternatingSequenceOddEven {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 7, 8};
        System.out.println(findAlternatingEvenOdd(a));
        System.out.println(findAlternatingEvenOddOptimised(a));

    }

    public static int findAlternatingEvenOdd(int[] nums){
        int count = 1;
        int longest = 1;
        for(int i = 0; i < nums.length-1; i++){
            if((nums[i] + nums[i+1]) % 2 == 1) {
                count++;
            } else {
                longest = Math.max(longest, count);
                count = 0;
            }
        }
        if (longest == 1)
            return 0;
        return Math.max(count, longest);
    }
    // Time O(n)
    // Space O(1)
    public static int findAlternatingEvenOddOptimised(int[] nums){
        int n = nums.length;
        int left = 0, right; // stretch right pointer as far as possible
        int ans = 0;
        // {1, 2, 3, 4, 5, 7, 8, 9, 10, 11, 12}
        // 3 % 2 = 1 , 2 % 2 = 0
        // nums[right + 1] % 2 + nums[right] % 2 == 1
        while (left < n){
            right = left;
            while (right +1 < n && nums[right + 1] % 2 != nums[right] % 2 ){
                right++;
            }
            // reach where you can no longer stretch
            ans = Math.max(ans, right- left + 1);

            left = right + 1;
        }
        return ans;

    }
}

/*

1, 2, 3, 4, 5, 7, 9
i = 0
j = 4
j - i + 1 = 4 + 0 + 1 = 5

 */
