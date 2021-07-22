package heap;
import java.util.Comparator;
import java.util.PriorityQueue;
public class Heap {
    public static void main(String[] args) {
        // min Heap
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        System.out.println("Adding values");
        for(int i : new int[] { 5, 7, 3, 8, 0}){
            priorityQueue.add(i);
            System.out.println(priorityQueue);
        }

        System.out.println("Popping elements");
        while(!priorityQueue.isEmpty()){
            System.out.println("Popped : " + priorityQueue.poll()+ " ," + priorityQueue);
        }

        // maxHeap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        System.out.println("Adding values");
        for(int i : new int[] { 5, 7, 3, 8, 0}){
            maxHeap.add(i);
            System.out.println(maxHeap);
        }

        System.out.println("Popping elements");
        while(!maxHeap.isEmpty()){
            System.out.println("Popped : " + maxHeap.poll()+ " ," + maxHeap);
        }

       // PriorityQueue<Integer> pq = new PriorityQueue<>(a,b) -> Integer.compare(a% 2, b % 2);
        PriorityQueue<Integer> pq= new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return Integer.compare(a % 2,b % 2);
            }
        });
    }
}
