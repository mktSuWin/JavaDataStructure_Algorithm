package tree;
/*
Inorder traversal - left, Root, right
Recursion
---------
- Traverse left subtree
- visit root
- visit right subtree

Iterative algorithm
-------------------
Convert recursive algorithm to iterative algorithm using an explicit stack
                                A
                             /        \
                       B                    I
                    /     \               /   \
                  C         F             J     O
                /   \        \             \        \
              D      E       G              K       P
                            /              / \
                           H             L    N
                                          \
                                           M


Note:
- Deletion is post order traversal
- left, right, child
            +
         *    5
      4    -
         7   2


         left, right , root
         4 * 7 , 2, - ,*
 */

import java.util.*;

class BinaryTreeNode<T>{
    public T data;
    public BinaryTreeNode<T> left, right;
}

public class E1_InorderTraversal {
    public static void main(String[] args) {

    }
                    /*
                                A
                          B          C
                      D     E           F
                               G
                    // D, B, E, G, A, C, F

                      |   |
                      | G |
                      | A |
                      _____

                      result =  { D, B, E, G ,
                     */
    public static List<Integer> inOrderTraversal(BinaryTreeNode<Integer> tree){
        Deque<BinaryTreeNode<Integer>> stack = new LinkedList<>();
        BinaryTreeNode<Integer> current = tree;
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty() || current !=null){
            if (current !=null){
                stack.addFirst(current);
                // Visit left
                current = current.left;
            } else {
                // Go up
                current = stack.removeFirst();
                result.add(current.data);
                // Visit right
                current = current.right;
            }
        }
        return result;
    }

    // root, left, right
    public static List<Integer> preOrderTraversal(BinaryTreeNode<Integer> root){
        List<Integer> result = new ArrayList<>();
        // edge case
        if (root == null) return result;
        Deque<BinaryTreeNode<Integer>> stack = new ArrayDeque<>();
        stack.push(root);
        while (!stack.isEmpty() || root !=null){
            BinaryTreeNode node = stack.pop();
            result.add((Integer) node.data);
            if (root.right!=null){
                stack.push(root.right);
            }
            if (root.left != null){
                stack.push(root.left);
            }
        }
        return result;
    }
}
