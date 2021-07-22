package tree;
/*
longest path in a tree - from leaf node to leaf node
Any path having maximum num of nodes

LB1_TreeHeight treeHeight = new LB1_TreeHeight();
int leftHeight = treeHeight.GetHeight(root.Left);
int rightHeight = treeHeight.GetHeight(root.Right);
int totalTreeHeight = leftHeight + rightHeight + 1;
int subTreeHeight = (leftHeight > rightHeight) ? leftHeight : rightHeight;
return (subTreeHeight > totalTreeHeight) ? subTreeHeight : totalTreeHeight;


//=====================================
// Hari
public int GetDiameter(TreeNode root)
        {
            TreeHeight treeHeight = new TreeHeight();
            int leftHeight = treeHeight.GetHeight(root.Left);
            int rightHeight = treeHeight.GetHeight(root.Right);
            int totalTreeHeight = leftHeight + rightHeight + 1;
            int leftSubtreeeDiameter = GetDiameter(root.Left);
            int rightSubtreeeDiameter = GetDiameter(root.Right);
            int subTreeHeight = (leftSubtreeeDiameter > rightSubtreeeDiameter) ? leftSubtreeeDiameter : rightSubtreeeDiameter;
            return (subTreeHeight > totalTreeHeight) ? subTreeHeight : totalTreeHeight;
        }

// Pradeep
=====================================================
public static int diameter(Node root) {
          // Write your code here.
          if (root==null){
              return 0;
          }
        int dm=1;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int d1 = leftHeight + rightHeight +1;

        int leftHeight1 = height(root.left.left);
        int leftHeight2 = height(root.left.right);

        int rightHeight1 = height(root.right.left);
        int rightHeight2 = height(root.right.right);

        if d2= leftHeight1 + leftHeight2 +1;
        if d3= rightHeight1 + rightHeight1 +1;

        if(d1 > d2 && d1 > d3) {
            dm = d1;
        } else if(d2 > d3) {
            dm = d2;
        } else {
            dm = d3;
        }

        return dm;
    }

 */
public class lc_543_DiameterOfBinaryTree {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left.data = 2;
        node.right.data = 3;
        node.left.left.data = 4;
        node.left.right.data = 5;
        findDiameterTree(node);

    }

    public static int findHeight(TreeNode root) {
        if (root == null) return 0;
        else{
            int leftHeight = 1 + findHeight(root.left);
            int rightHeight = 1 + findHeight(root.right);
            return (leftHeight > rightHeight) ? leftHeight : rightHeight;
        }
    }

    public static int findDiameterTree(TreeNode root){
        if (root== null) return 0;
        int leftH = findHeight(root.left);
        int rightH = findHeight(root.right);
        int leftDiameter = findDiameterTree(root.left);
        int rightDiameter = findDiameterTree(root.right);
        int diameterViaRoot = 1 + leftH + rightH; // when diameterNotViaRoot pass via root
        int diameterNotViaRoot = Math.max(leftDiameter, rightDiameter); // when diameterNotViaRoot not pass via root
        return (diameterViaRoot > diameterNotViaRoot)? diameterViaRoot : diameterNotViaRoot;

    }
    static int answer = 0;
    public static int findDiamterTree_1(TreeNode root){

        // Keep track of two values
        // one is answer which is global variable
        getDiameter(root);
        return (answer == 0)? 0 : answer-1;
    }

    public static int getDiameter(TreeNode root){
        // base case
        if (root == null) return 0;
        // find the length of left side of the root node
        int leftHeight = getDiameter(root.left);
        int rightHeight = getDiameter(root.right);

        answer = Math.max(answer, leftHeight + rightHeight + 1); // 1 means including the current node
        return Math.max(leftHeight, rightHeight)+1;
    }

    public static int findDiameterTreeRecursive(TreeNode root){
        if (root == null) return 0;
        // Case 1 : find both leftSub-tree height and right sub-tree height
        int leftHeight = heightOfBinaryTree(root.left);
        int rightHeight = heightOfBinaryTree(root.right);
        int diameter_PassThroughRoot = leftHeight + rightHeight + 1;
        // Case 2 : Find leftSub-tree diameter (it does not pass through root)
        int leftDiameter = findDiameterTreeRecursive(root.left);
        int rightDiameter = findDiameterTreeRecursive(root.right);
        int diameter_NotPassThroughRoot = Math.max(leftDiameter, rightDiameter);

        int finalDiameter = Math.max(diameter_PassThroughRoot, diameter_NotPassThroughRoot );
        return finalDiameter;
    }
    // Maximum depth of a binary tree
    public static int heightOfBinaryTree(TreeNode root){
        int maxHeight =0;
        if (root == null) return 0;
        // Step 1
        int leftHeight = heightOfBinaryTree(root.left);
        // Step 2
        int rightHeight = heightOfBinaryTree(root.right);
        // Step 3
        if (leftHeight > rightHeight){
            maxHeight = leftHeight +1;
        } else {
            maxHeight = rightHeight +1;
        }
        return maxHeight;
    }

}
