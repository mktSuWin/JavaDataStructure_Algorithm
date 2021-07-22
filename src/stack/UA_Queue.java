package stack;

public class UA_Queue {
    int[] queue;
    int front;
    int end; // size - number of elements currently in the queue

    public UA_Queue(){
        this.queue = new int[5];
        this.front = 0;
        this.end = 0;
    }

    public boolean isEmpty(){
        return end ==0;
    }

    public boolean isFull(){
        return end == queue.length;
    }
    /*              F       end
      0     1   2   3   4   5
                    10  20  30
                (3 + 5)% 6 = 2
   ---------------------------------
                End F
      0     1   2   3   4   5
                45  10  20  30

     */
    public void enqueue(int x){
        if (isFull()) return;
        int index = (front + end) % queue.length;
        queue[index] = x;
        end++;
    }

    public int dequeue(){
        if (isEmpty()) return -1;
        int temp = queue[front];
        queue[front] =0;
        front = (front+1) % queue.length;
        end--;
        return temp;
    }

    public int peekFront(){
        if(isEmpty()) return -1;
        return  queue[front];
    }

    public void displayQueue(){
        System.out.println("------------------------");
        for(int i = front; i <= (front+end); i++ ){
            System.out.print(queue[i % queue.length] + " ");
        }
        System.out.println();
        System.out.println("------------------------");
    }
}
