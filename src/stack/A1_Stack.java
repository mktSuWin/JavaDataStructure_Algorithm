package stack;

import java.util.*;
/*
Synchronise
 */
public class A1_Stack {
    public static void main(String[] args) {
//        Stack<String> stack = new Stack();
//        stack.push("One");
//        stack.push("two");
//        stack.push("three");
//        int index = (stack.search("three"));
//        System.out.println(index);

//        Iterator<String> iterator = stack.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

//        for(String e : stack){
//            System.out.println(e);
//        }

//       List<String> list = new ArrayList<>();
//       list.add("1");
//       list.add("2");
//       list.add("3");
//        System.out.println(list);
//        while(list.size() >0){
//            stack.push(list.remove(0));
//        }
//        System.out.println(list);
//
//        while (stack.size() >0){
//            list.add(stack.pop());
//        }
//        System.out.println(list);

//        Deque<String> stack = new ArrayDeque<>();
//        stack.push("One");
//        stack.push("Two");
//
//        String one = stack.peek();
//        String two = stack.pop();
//        stack.peek();

//        Queue<String> queue = new LinkedList<>();
//        Queue<String> queue1 = new ArrayDeque<>();
//        // enqueue and deque
//        Queue<String> queue2 = new PriorityQueue<>();
//        // allows you by pass
//        queue.add("tokyo");
//        queue.add("osaka");
//        queue.offer("kamakura");
//        System.out.println(queue.size());
//        // queue.remove(); // throws an exception
//        queue.poll(); // null
//        System.out.println(queue.size());
//        System.out.println(queue.contains("nara"));
//
//        Iterator<String> iterator = queue.iterator();
//        while(iterator.hasNext()){
//            System.out.println(iterator.next());
//        }
//
//        queue.stream().forEach(nextElement) ->{
//            System.out.println(nextElement);
//        };
        Deque<String> deque = new ArrayDeque<>();
//        Deque<String> linkedList = new LinkedList<>();
//        // Queue mode
//        deque.offerLast("osaka");
//        deque.offerLast("kamakura");
//
//        String city1 = deque.pollFirst();
//        String city2 = deque.peekFirst();
//
//        // Stack mode
//        deque.offerFirst("nagano");
//        deque.offerFirst("aomori");

        deque.add("apple");
        deque.addLast("organe");
        deque.addFirst("banana");





    }
}
