package stack;

import linkedList.UA_1_BasicLinkedList;

public class UA_Stack {
    int[] stack;
    int top; // top pointer

    UA_Stack(){
        this.stack = new int[5];
        this.top = -1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public boolean isFull(){
        return stack.length -1 == top;
    }

    public void push(int x){
        if (isFull()) return;
        top++;
        stack[top] = x;
    }

    public int pop()throws Exception {
        if (isEmpty()) {
            throw new Exception("Stack is empty.");
        }
        int temp = stack[top];
        stack[top] =0;
        top--;
        return temp;
    }

    public int peek() throws Exception{
        if(isEmpty())
            throw new Exception("Stack if empty");
        int temp = stack[top];
        return temp;
    }

    public void display(){
        for(int i =top; i >= 0; i--){
            System.out.println("----------------------------");
            System.out.print(stack[top] + " ");
            System.out.println("----------------------------");
            top--;
        }
    }
}
