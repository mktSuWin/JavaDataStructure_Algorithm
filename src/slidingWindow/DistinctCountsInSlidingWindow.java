package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DistinctCountsInSlidingWindow {
    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        int[] result = distinctCountsInEachWindow(A, B);
        for(int i : result){
            System.out.print(i + " ");
        }

    }
    /*

     */
    public static int[] distinctCountsInEachWindow(int[] A, int B){
        int[] answer = new int[A.length - B + 1];
        // Initialise HashMap
        Map<Integer, Integer> map = new HashMap<>();
        // Create the first window and
        // Put all elements and their counts
        for(int i =0; i < B; i++){
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        }
        // Add the first window size into list
        answer[0] = map.size();
        //Move window , Remove the first element and add the next element
        for(int i = 1; i <= A.length - B; i++){
            int removeElement = A[i-1];

            // remove element
           removeElementFromMap(map, removeElement);
            // Add element into the window
            int addElement = A[i+B-1];
            map.put(addElement, map.getOrDefault(addElement, 0)+1);
            // Add the new window size into list
            answer[i] = map.size();
        }
        return answer;
    }
    
    public static void removeElementFromMap(Map<Integer, Integer> map, Integer element){
        Integer count = map.get(element);
        if (count != null && count > 1){
            map.put(element, count-1);
        } else {
            map.remove(element);
        }
    }


    public static int[] distinctCountsInEachWindow1(int[] A, int B){
        int[] answer = new int[A.length - B + 1];
        HashMap<Integer, Integer> map = new HashMap<>();
        // Create the first window and put the elements and counts into HashMap
        for(int i =0; i < B; i++)
            map.put(A[i], map.getOrDefault(A[i], 0)+1);
        // Add first window size into answer
        answer[0] = map.size();

        // Slide the window, Therefore, starts from i = 1
        for(int i =1; i < A.length; i++){
            // This will get count of first element in previous window (i-1)

            int counter = map.get(A[i-1] -1);
            if (counter == 0){
                map.remove(A[i-1]);
            } else{
                map.put(A[i-1], counter);
            }
            // Slide the window and add an element to the right
            // Index      0  1  2  3  4  5
            // int[] A = {1, 2, 1, 3, 4, 3};
            //                     ^
            // i = 1, B = 3 , 3 + 1 = 4 -1 = 3
            int windowRight = i + B -1;
            if (windowRight >= A.length){
                break;
            }
            map.put(A[windowRight], map.getOrDefault(A[windowRight], 0)+1);
            answer[i] = map.size();
        }
        return answer;
    }
}
