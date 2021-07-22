package linkedList;
/*
RIYABANSAL

Array is a linear data structure
Contiguous memory location
LinkedList is also a linear data structure
Nodes are present in random location
node
singly linkedlist
Functionality of random access
First part = node information
second part = address to the next node
ArrayList

Structure of a node in a LinkedList
class Node {
    int data; // information
    Node next; // address of next node
}

Where is this linkedlist starting, where is ending.
Head pointer = start of the linkedlist
Tail pointer = end of the LinkedList


Advantages
1. Dynamic size - you don't need to know the size in advanced
2. Easy insertion, deletion

Insertion
=============================
- at front
- at end
- at middle
Head
 |
 V
30 -> 40 -> 50 -> 60
New head
70 -> 30 -> 40 -> 50 -> 60
1. Make a new node n which is 70
2. Make n.next = head;
3. Make head points to n.
    head = n;

// Print LinkedList
Node temp = head;
while (temp b !=null) {
    temp = temp.next;

// Add at last
1. Make a new node when temp.next == null
2. temp.
}


// Add the node in the middle
   index and data
   3        40
   if (index == 0) add addAtFirst();
   0      1     2     3     4     5    6
   80 -> 90 -> 50 -> 40 -> 60 -> 70 -> x
   1. First create a new Node
   2. temp.next = newNode;
   3. newNode.next = temp.next;

// Delete at front
    head = head.next;

// Delete at last
    Iterate till
 */
public class UA_1_BasicLinkedList {
    private class Node{
        int data;
        Node next; // Store the address of the next node

        Node(int data){
            this.data = data;
            this.next = null;
        }
    }

    private Node head;
    private int size;
    // Time O(1)
    public void addAtFirst(int data){
        // Make a new node
        Node newNode = new Node(data);
        // Change head to nextNode
        newNode.next = head;
        // Make head points to n
        head = newNode;
    }
    // Time : O(n)
    public void printLinkedList(int data){
        Node temp = head;
        while (temp != null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    // Time complexity O(n)
    public void addAtLast(int data){
        Node newNode = new Node(data);
        if (head == null){
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }

        temp.next = newNode;

    }
    // Time O(n)
    public void addAtMiddle(int index, int data){

        if (index < 0) return;
        if (index == 0) {
            addAtFirst(data);
            return;
        }

        Node nn = new Node(data);
        // go until the
        Node temp = head;
        for(int i = 0; i < index-1; i++){
            temp = temp.next;
        }
        temp.next = nn;
        nn.next = temp.next;
    }

    public void deleteAtFront(){
        head = head.next;
        return;
    }
    // Go to the second last element
    public void deleteAtEnd(){
        Node temp = head;
        // You want to get to the second last element
        while (temp.next != null){
            temp = temp.next;
        }
        // Remove the last element
        temp.next = null;
    }
    // 0    1   2   3   4
    // 10   20  30  40  50  null
    // temp node
    public void deleteAtMiddle(int index){
        Node temp = head;
        for(int i = 0;  i < index -1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;

    }

    // 40   30  50  60  70  x
    // How to delete the entire linkedlist
    // Most efficient way
    // head == null;


    // Find nth node of linkedlist
    // 0    1   2   3    4
    // 30   40  50  60  70  null
    // at index 2.
    public int findNthNodeOfLinkedList(int index){
        Node temp = head;
        for(int i = 0; i < index-1;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    // Find nth node from end
    // 0    1   2   3    4
    // 30   40  50  60  70  null
    // if n = 3, output = 50
    // if n = 2, output = 60
    // if n = 4, output = 40
    /*

    Calculate size of linkedlist
    Approach
    ==========================
    Start from head
    30   40  50  60  70  null
                 n = 2
    if size of linkedlist is 5, size - n, get the element at 3rd index

     */
    // O(n)
    public int findNthNodeFromEnd(int index){
        // FInd the linkedlist size
        Node temp = head;
        int count = 0;
        while (temp !=null){
            temp = temp.next;
            count++;
        }
        // move size - n step from head
        temp = head;
        for(int i = 0; i < count - index; i++){
            temp = temp.next;
        }
        return temp.data;
    }
    // 2nd Approach
    // Two pointer approach
    // 0     1   2   3   4
    // 30   40  50  60  70  null
    //          <--------- n = 3
    // n = 3
    // both pointers at the beginning of the position
    // temp1
    // temp2
    // Move n nodes from the head
    // Create n difference steps between temp1 and temp2
    // Then move both pointers at the same time till temp2
    public int findNthNodeFromEnd_TwoPointers(int index){
        // Make them n distance apart
        Node temp1 = head;
        Node temp2 = head;
        for(int i = 0; i < index; i++){
            temp2 = temp2.next;
        }
        // Move two pointers simultaneously
        while(temp2.next != null){
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        // temp1 is at the required position.
        return temp1.data;
    }
    // Question 1
    // Reverse a linkedlist
    // Input    : 10   20  30  40   50  null
    // Output   : 50 <-  40<-  30 <- 20 <-  10
    /*
        Three Pointer Approach
        --------------------
        previous
        current
        next

        while (curr.next != null)
            curr.next = previous
       Both recursion and iterative approach can be used.
       LinkedList is a recursive data structure.
       Why? Every sublist of the LinkedList is linkedlist.

       Every child in a tree is a tree itself.

       Approach 1 - Iterative Approach
       Use the reversed pointer

    // Input    : 10   20  30  40   50  null
    // Output   : 50 <-  40<-  30 <- 20 <-  10

    head is at 10.
        // Input    : 10   20  30  40   50  null
        // Use two pointers approach but failed. Since nothing is pointing to 30,
        // 30 becomes unreachable.
        head = 10
        temp1 = 10
        temp2 = 20

        temp2.next = temp1
        temp1.next = null;

        // Use three pointers approach
        // Input    : 10   20  30  40   50  null
        head = 10
        previous= null
        curr = null
        next = null

        curr = head;

        while (curr != null)
        next = curr.next;
        curr.next = previous
        // Shifting operations
        previous = curr;
        curr = next;


     */

    // 30   40  50  60  70  null
    //          <--------- n = 3
    public void reverseLinkedLIst(int data){
        Node previous = null;
        Node next = null;
        Node curr = head;
        while (curr != null){
            next = curr.next;
            curr.next = previous;
            previous = curr;
            curr = next;
        }
    }

    /*
    Question - 2 reorder the list. Folding a linkedlist
    You are given a singly linkedlist.
    L0  L1  L2  L3 ... Ln-1 Ln
    L0  Ln  L1  Ln-1  l2    Ln-2....
    1   2   3   4   5
    1   5   2   4   3

    1   2   3   4   5   6

    1. Find the middle of LinkedList O(n)
    2. Break it into two linkedlist from the middle O(n)
    3. Reverse the second half of the LinkedList
    4. Merge both of the LinkedList by re-ordering O(n)
     */
    // 1. Find the middle of LinkedList
    static int findMid(Node head){
        Node slow = head;
        Node fast = head;
        // fast != null odd length
        // fast.next != null even length
        while (fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    // 1    2   3   4   5   6
    // 1    2   3   6   5   4 - in place reversed
    // 1    2   3
    // 6    5   4
    /*
    static int breakLLIntoTwo(int index){
        Node prev = null;
       // Node slow = head;
        Node curr = slow;
        Node temp = null;
        while (curr != null){
            temp = curr.next;
            curr.next = prev;
            // shifting the pointer
            prev = curr;
            curr = temp;
        }
    }

 first    1   2   3   4
 second   6   5   4
    Node first = head;
    Node second = prev;
    while ( second.next != null) {
        Node temp = first.next;
        first.next = second;
        first = temp;
        temp = second.next;
        second.next = first;
        first = temp;
    }
     */

    // Merge two sorted intervals
    // L1   1   3   7   9   12
    // L2   4   8   9   10  13  15
    // merge 1  3   4   7   8   9   10  12  13  15

    /*
    Intersection of LinkedList
    ==========================
    4   1
            8   4   5
5   0   1
    Intersection point of the 2 LinkedList
    Output => 8
    Approach 1 - Brute Force
    ======================
    for each node in A,
    - traverse the entire list of B
    - check if there is a coinciding element - address.
    - At this point of time, you find it.

    A => length m
    B => length n
    Time O (mn)

    Approach 2 - Optimised
    =======================
    1. Traverse the LinkedList A and store all its addresses in a HashMap
       Address      Value
       100          4
       200          1
       300          8
       400          4
       500          5
    2. Traverse LL B and find if the address is already present in HashMap
    Time O(m + n)
    Space O(m)

    Approach 3 - More Optimised
    ===========================
    - After intersection point 8, there will be same number of nodes in both LL-A and LL-B.

    - Two people Runner A and B
    A           common point ----> same
    B           common point

    speed of A = speed of B

          A     common point ----> same
    B           common point (No cheater)
    If one of them cheats, that node will win.
    Two pointers run at the same speed.
    Since A has less node to traverse, it will reach the common point earlier.
    Therefore B ideally should start the same node from intersection.
    If you check (p1 == p2), you will get the intersection.


   abs( length of A - length of B)
   abs (5 - 7)
   abs 2
   if (lenOfA) > lenOfB
    shift A by abs(lA - lB)
    else
        shift B by abs(lA - LB)

    static int intersectionOfLinkedList(Node a, Node b){

    }
     */


    /*
    Partitioning Question
    =====================
    Given a LinkedList and a value x.
    Partition it such that all nodes less than x, come before nodes greater than or
    equal to x.

    Preserve the ordering of elements
    1   4   3   2   5   2, x = 3
    1   2   2   3   4   5
    2   2   1   4   3   5 <= incorrect ordering

    1   2   2   3   4   5
    Traverse the LinkedList
    Initialise 3 as Node head
    3 vs 1 , 1, 3
    3 vs 4, 3 < 4 , therefore, New LinkedList 1, 3, 4
    3 vs 3, it is the element, do nothing
    3 vs 2, 3 > 2, 2 > 1,therefore  1   2   2   3   4
    3 vs 5, 3 < 5, 5 > 4, therefore 1   2   2   3   4   5

    Example 2 : Input
    1   11  7   9   17  15  17  21  10  18, x = 12
    1   11  7   9   10  17  15  17  21  18

    Change LinkedList structure
    - LL1  : all elements less than x, must be before that + JOINT (x) +
    - LL2  : all elements greater than x, must be after x

    Traverse the original linkedlist
    Divide the LinkedList into two lists : 1) less than x 2) greater than x
    Do this using two Pointer Approaches
    1   4   3   2   5   2   , x
    before pointer with dummy value 0 -> x
    head pointer                    0 -> x
    Make a temp pointer to the head
    if (temp.value < x) {
        // go to before linkedlist
        // then move temp pointer
        // 0 -> 1 -> 2 -> 2
    } else {
        // go to after linkedlist
        // 0 -> 4 -> 3 -> 5
    }

    Since there are no Node left, you have finished your traversal.
    before = before.next; therefore make it head.
    after = after.next;
    temp.next = after;

    // Time : O(n)
    // Space O(1)
    static void partition(Node head, int x) {
        // Dummy nodes for two linkedlist
        Node beforeHead = new Node(0);
        Node afterHead = new Node(0);
        Node before = beforeHead;
        Node after = afterHead;

        while(head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        // make a connection between
        before.next = afterHead.next;
    }
     */


    /*
    Question : Palindrome LinkedList
    =================================
    - Odd len
    - Even len palindrome
    LL, check if it is a palindrome.
    naman
    1   2   3   2   1 return true
    1   2   2   4   5 return false
    Constraint: No space

    Length
    - even - a b a a b a
    - odd - a b c b a
    Find mid of LinkedList using slow and fast pointers approach
    - break the LinkedList in the middle
    - head1 => 1     2   3
    - head2 => 2     1 , then reverse this second LinkedLIst
    -          1     2
    - Then compare both elements
    - If one LL ended and only one element left, this is a palindrome of odd length

    - arpit
      a r
      t i , not match

      if LinkedList is even it should be at mid joint
      if LinkedList is odd, it should be at mid point
    - 1 2   3   3   2   1
    - 1 2   3
    - 1 2   3

    1 2 3
    s s s
    f   f   f // odd case, fast.next == null

    1 2 3 4
    s s s
    f   f   f // even case fast = null

    if (len % 2 == 0) fast = null;
    // Finding mid point
    // even len case -> fast !=null
    // odd len case -> fast.next != null
    //---------------------------------------------------
    if ( fast !=null && fast.next != null)

    static boolean isPalindrome(Node head) {
        // corner case
        if (head == null || head.next == null) return true;
        Node prev = head;
        Node slow = head; // mid is slow pointer
        Node fast = head;
        // Finding mid
        //====================================
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // frist LinkedList
        // Breaking it into two parts
        //======================================
        while (prev.next != mid && prev.next != null) {
            prev = prev.next;
            Node n = null;
            if (fast == null) { // even
                n = slow;
                pre.next = null;
            } else { // odd len
                n = slow.next;
                slow.next = null;
            }
        }
        // Compare
        Node second = reverse(n);
        while (second != null && head !=null) {
            if (second.val != head.val) {
                return false;
            }
            second = second.next;
            head = head.next;
        }
        return true;
    }
    // Write this function
    static void reverseLinkedList(Node head) {

    }
     */

    /*
    Question : k - reverse LinkedList
    Given a LinkedList, reverse the nodes of a LinkedLIst k at a time and get the modified list.
    k is an integer <= length of the LinkedList

    Input :     1   2   3   4   5   , k = 2
                2   1

    Input :     1   2   3   4   5   , k = 3
                3   2   1

    Input :     1   2   3   4   5   , k = 4
                4   3   2   1

    head is at  1
    recursion will start from head of the LinkedList
    First step
    - Count k nodes , the remaining linkedlist is the LL itself and recursively call
    - Base case
    - increment
            3   4   5
            The remaining LinkedList is 5. It does not have enough nodes to reverse. You cannot do reversal anymore.
    - Make a proper connection after that
    - 4 3   5



    1   2   3   4   5   6
    ^
    newHead

    static reverseK(Node head, int k ) {
        int count = 0;
        Node pointer = head;
        while (count < k && pointer != null) {
            pointer = pointer.next;
            count++;
        }

        if (count == k) {
            Node head = reverse(head, k);
            Node newHead = reverse(head, k);
            head.next = reverseK(pointer, k);
        }
        return newHead;
    }

    static void reverse(Node head, int k ) {

    }

     */



}




