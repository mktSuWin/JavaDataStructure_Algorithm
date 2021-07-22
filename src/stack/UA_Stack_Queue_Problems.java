package stack;

import java.util.Stack;

public class UA_Stack_Queue_Problems {
    public static void main(String[] args) {
        int[] array ={ 13, 7, 6, 12, 10};
        int n = array.length;
        // nextGreaterElement(array);
        long[] result = nextGreaterElement2(array, n);
        for(long i : result){
            System.out.print(i + " ");
        }

    }

    /*
    Question 1 :
    Next Greater element | Find the just greater element on the right
    side of each element.
    Input:  4   5   2   25
    Output: 5   25  25  -1

    Input : 10  7   4   2   9   10  11  3   2
    Output: 11  11  11  11  11  11  -1  -1  -1

    Input:   6  4   5   3   1
    Output: -1  -1  -1  -1  -1

    5   4   3   2   1   10
    10  10  10  10  10  10

    11  4   3   10  12
    -1  10  10  10  -1

    12  11  4   2   1   11

    1. Iterate the array and keep track of the largest one and its index
    Math.max(x, );
    index
    push them into stack
    11  4   2   10   2
    4
    2
    Compare top with next element 10
    11  10  10  12


     */
    // https://www.geeksforgeeks.org/next-greater-element/
    public static void nextGreaterElement(int[] array){
        Stack<Integer> stack = new Stack<>();
        stack.push(array[0]);
        stack.push(0);
        for(int i = 1; i < array.length; i++){
            int next = array[i];
            if (!stack.isEmpty()){
                int popped = stack.pop();
                while (popped < next){
                    System.out.println(popped + "--> " + next);
                    if (stack.isEmpty()){
                        break;
                    }
                    popped = stack.pop();
                }
                if (popped > next){
                    stack.push(popped);
                }
            }
            stack.push(next);
        }
        while (!stack.isEmpty()){
            int popped = stack.pop();
            int next = -1;
            System.out.println(popped + " -->" + next);
        }
    }
    /*
    Naive Approach
    Pick element which is greater than that element
    O(n^2)
    5   4   3   2   1
     */
    public static void nextGreaterElement1(int[] array){
        for(int i = 0; i < array.length; i++){
            int element = array[i];
            for(int j = i; j < array.length;j++){
                if (array[j] > element){
                    array[i] = array[j];
                } else{
                    array[i] = -1;
                }
            }
        }
    }
    /*
    Rule: smaller or equal elements' indexes can be pushed
    // to the top of the stack
    11, 4, 3, 10, 12

    0   1   2   3   4
    13  7   6   12  10
    -1  12  12  -1  -1

    12 > 6, therefore pop index 2, in that place, add 12
    Check for next element, 7 < 12, therefore, pop index, add 12

    4 10 < 12 , theefore, push index 4
    3
    0

    Whatever left in the stack, add -1
     */
    public static long[] nextGreaterElement2(int[] array, int n){
        // Your code here
        long[]a=new long[n];
        for(int i=0;i<n;i++) {
            a[i]=-1;
        }
        Stack<Integer> st=new Stack<>();
        st.push(0);
        for(int i=1;i<n;i++) {
            if(array[i]<=array[st.peek()]) {
                st.push(i);
            }
            else {
                while(st.size()!=0 && array[i]>array[st.peek()]) {
                    int x=st.peek();
                    a[x]=array[i];
                    st.pop();
                }
                st.push(i);
            }
        }
        return a;
    }

    /*
    Question 2 :
     */

    /*
    Question 3 :
     */
}
