package cb_CPMSoc.CPM;

import java.util.Scanner;
import java.util.Stack;
public class Workshop_2_Stack {
    public static void main(String[] args) {
        while (true) {
            int N;
            int array[] = new int[1000];
            Scanner sc = new Scanner(System.in);
            N = sc.nextInt();
            if (N == 0) {
                break;
            }
            for (int i = 0; i < N; i++) {
                array[i] = sc.nextInt();
            }
            Stack<Integer> s = new Stack<>();
            int biggestInTheEnd = 0;
            for(int i = 0 ; i < N; i++) {
//                System.out.println("Pushing array[i] into stack: " + array[i]);
                s.push(array[i]);
                while ( !s.isEmpty() && s.peek() == (biggestInTheEnd +1)) { // amortised complexity O(n)
//                    System.out.println("Peek array[i] from stack" + s.peek());
                    s.pop(); // remove top of stack
                    biggestInTheEnd++;
                }
            }
            if (s.isEmpty()) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }

}
