package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class lc_227_BasicCalculator2 {
    public static void main(String[] args) {
        String s = "33+2*2";
        String s2 = "3-5  / 2";
        System.out.println(calculate_Stack(s2));
        System.out.println(calculateWithoutStack(s2));
    }

    public static int calculate_Stack(String s) {
        // edge case check
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int current = 0;
        char operation = '+';
        // Convert the given string into character array
        char[] sChar = s.toCharArray();

        //Iterate through character array
        for(int i =0; i < sChar.length; i++){
            // if it is 0 to 9
            if (Character.isDigit(sChar[i])){
                current = current * 10 + sChar[i] - '0';
            }
            // if it is +,-, *, /
            if (!Character.isDigit(sChar[i]) && sChar[i] != ' ' || i == sChar.length-1){
                if (operation == '+'){
                    stack.push(current);
                } else if (operation== '-'){
                    stack.push(-current);
                } else if (operation == '*'){
                    stack.push(stack.pop() * current);
                } else if (operation == '/'){
                    stack.push(stack.pop() / current);
                }
                operation = sChar[i];
                current = 0;
            }
        }
        int sum = 0;
        while (!stack.isEmpty()){
            sum += stack.poll();
        }
        return sum;
    }

    public static int calculateWithoutStack(String s){
        if (s == null || s.length() == 0) return 0;
        int current = 0;
        char operation = '+';
        char[] sChar = s.toCharArray();
        // while iterating through the char array, keep track of the calculation
        int sum = 0;
        int tempSum = 0;
        for (int i =0; i < sChar.length;i++){
            if (Character.isDigit(sChar[i])){
                current = current * 10 + sChar[i] -'0';
            }

            if (!Character.isDigit(sChar[i]) && sChar[i] != ' ' || i == sChar.length-1){
                switch (operation){
                    case '+':
                        sum += tempSum;
                        tempSum = current;
                    break;
                    case '-':
                        sum += tempSum;
                        tempSum = current;
                    break;
                    case '*':
                    tempSum *= current;
                    break;
                    case '/':
                    tempSum /= current;
                    break;
                }
                operation = sChar[i];
                current = 0;
            }
        }
        sum += tempSum;
        return sum;
    }
}




/*
Inorder Traversal : 

root 2
stack 1, 2, 4,

result 4,
 */




















































