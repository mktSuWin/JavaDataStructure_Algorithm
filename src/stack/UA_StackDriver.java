package stack;

import java.util.LinkedList;
import java.util.List;

public class UA_StackDriver {
    public static void main(String[] args) throws Exception {
        UA_Stack stack = new UA_Stack();
        stack.push(30); // 30   20  60
        stack.push(100);
        stack.push(20);
        stack.push(10);
        stack.pop();
        stack.push(60);
        stack.display();
        System.out.println(stack.peek());

        List<Integer> queue = new LinkedList<>();

    }
}
