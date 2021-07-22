package LinkedListProblems;

public class LinkedList<I extends Number> {
    Node head;

    public void insertAtStart(int data) {
        Node temp = new Node(data);
        if (head == null) {
            head = temp;
        } else {
            temp.next = head;
            head = temp;
        }
    }

    public void insertAtLast(int data) {
        Node temp = new Node(data);
        Node current = head;
        if (current == null) {
            head = temp;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
    }

    public Node insertAtLastNode(int data) {
        Node temp = new Node(data);
        Node current = head;
        if (current == null) {
            head = temp;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = temp;
        }
        return temp;
    }

    // 2 3 5 6
    // data 1 = 3 , data2 = 5
    // insert 4
    public void insertAfter(int data1, int data2) {
        Node current = head;
        Node temp1 = new Node(data2);
        while (current.data != data1) {
            current = current.next;
        }
        Node temp2 = current.next; //5
        current.next = temp1;
        temp1.next = temp2;
    }

    public void deleteFromFirst(LinkedList<Number> list) {
        if (head == null) {
            System.out.println("LinkedList is empty. Nothing to delete");
        } else {
            head = head.next;
        }
    }

    public void printLinkedList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.next;
        }
    }


    public Node getMiddle() {
        Node slow = head;
        Node fast = head;
        while (fast != null && slow !=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}














































































