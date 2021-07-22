package cb_CPMSoc.CPM;

public class Workshop_1_PrefixSum {


    /*
            1, 0, -1, 2, 3, 2
            p[i] = a[1] + a[2] + a[3] + a[4];
     */

    public static void main(String[] args) {
//        int arr[] = {3, 1, 4};
//        System.out.println(arr[5]);
//        System.out.println(prefixSums(arr));
//        System.out.println(maxNum1(arr));

        int[] arr = {12, 0, 1, 12, -12};
        int target = 13;
//        System.out.println(badSubarrays(arr, target));
//        System.out.println(badSubarrays_Efficient(arr, target));
    }


    public static int prefixSums(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length;i++){
            sum += arr[i];
        }
        return sum;
    }


    public static int maxNum(int [] arr) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static int maxNum1(int[] arr) {
        int max1 = 0;
        int max2 = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max1){
                max2 = max1;
                max1 = arr[i];
            } else if (arr[i] > max2) {
                max2 = arr[i];
            }
        }
        int product = max1 * max2;
        return product;
    }


    // Time O(n^2)
    public static int badSubarrays(int[] arr, int target) {
        int sum = arr[0];
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length;j++) {
                sum += arr[j];
                if(sum == target){
                    count++;
                    break;
                }
            }
            sum = 0;
        }
        return count;
    }

    public static int badSubarrays_Efficient(int[] arr, int target) {

        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i-1];
        }

        int count = 0;
        for(int i = 0; i < arr.length;i++){

        }
        return count;
    }

    /*
        Keep track of the total number of points you have gained
        Which square is best to stop at
        (c) Anywhere online the line.
            Move once and stop somewhere else
            M could be

         (d) all elements are non negative
         Can make any number of moves
         Don't know where we start
         K = 10^9
         k - 1 * sum of elements

         (5) All Ai <= 0
         (k-1) * A[i] + subarray sum from M to i

         (6) Make two move and get the max score
            start point - move to two points. but you don't know where they are
            what remains constant
            what could change
            i j and M is move
            sum [M .. i] + sum [i..j]
            M   i   j       sum[M..i] + [i..j]
            M   j   i       sum[M..j] + [j..i]
            i   j   M       sum[i..j] + sum[j..M]
            j   i   M

            M   i   j
            M   j   i / j   M   i
            i   j   M / i   M   j
            j   i   M


            prefixSum

            Max(ps[j] - ps[M] + A[i])
            M is fixed. Vary
            |----------M----------i-------------j----------|
            ps[j] - ps[M-1] + A[i]

            for each j,from M to N
                calculate ps[j] (precalculated) // O(1)
                calculate ps[M-1] (precalculated) // O(1)
                largest_seen_so_far = max(largest, a[j]);
                Maximise a[i] where M <= i <= j // O(1)
                    maintain the largest a[i] we have seen so far


            M------------i----------------j

            Jump from M to j and then j to i
            back and forth between i and j

            k moves
            sum of the interval we jump
            Formula

            ps[i] - ps[M-1] + (k-1) * (ps[j] - ps[j-1])

          - ps[M -1] + ps[i] + (k-1) * ps[j] + (
            fixed       fix


            This is one of the four cases.
            M     i       j

            for i from M to N
                calculate ps[M -1]  - precalculated, fixed
                calculate ps[i]     - fixed
                calculate ps[i-1]   - fixed
                maintain maximum ps[j] seen so far



     */
    public static void walkScotch() {

    }

    public static void prefixSums_CumulativeSumQuery(int integerNum, int[] arr, int left, int right){
        // Prefix Sum
        // Store the possible numbers into this array
        arr = new int[integerNum];
        // Calculate the prefix sum array and insert the values into its corresponding i values
        arr[0] = arr[0];
        for(int i = 1; i < arr.length; i++){
            arr[i] = arr[i-1] + arr[i];
        }
        // To calculate the range
        int range = 0;
        for(int i = 0; i < arr.length; i++){
            range = arr[right] - arr[left-1];
        }
    }
}
