package thoughtWorks;

public class Tree { // Class names should start with an uppercase letter
    static class Node { // Renamed from Tree to Node for clarity
        Node leftChild;
        int data;
        Node rightChild;

        Node(int data) {
            this.leftChild = null;
            this.data = data;
            this.rightChild = null;
        }
    }

  
    static Node root = null; 
    // Public API method called by the main method
    private static void addChilds(int data) {
        // Kick off the recursion and assign the result back to root
        root = creteOtherNodesRecur(root, data);
    }

    // Recursive helper method that builds and returns the tree structure
    private static Node creteOtherNodesRecur(Node root, int data) {
        // Base Case: Found an empty spot, create the new node
        if (root == null) {
            return new Node(data);
        }

        // Recursive Case: Decide to go left or right based on the data value
        if (data < root.data) {
            root.leftChild = creteOtherNodesRecur(root.leftChild, data);
        } else {
            root.rightChild = creteOtherNodesRecur(root.rightChild, data);
        }

        // Return the current node up the call stack to maintain links
        return root;
    }

    // Inorder traversal of tree
    private static void printTree(Node root) {
        // Base Case: If the current node is null, do nothing and return
        if (root == null) {
            return;
        }

        // 1. Traverse the left subtree
        printTree(root.leftChild);

        // 2. Print the data of the current node
        System.out.print(root.data + " ");

        // 3. Traverse the right subtree
        printTree(root.rightChild);
    }

   private static Node deleteNode(Node root, int target) {
    // Base Case: The tree or subtree is empty
    if (root == null) {
        return null;
    }

    // Step 1: Navigate to the target node
    if (target < root.data) {
        root.left = deleteNode(root.left, target);
    } else if (target > root.data) {
        root.right = deleteNode(root.right, target);
    } 
    // Step 2: Target node found, handle the deletion
    else {
        // Case 1: No children (Leaf node)
        // Case 2: Only one child (Right child missing)
        if (root.left == null) {
            return root.right;
        } 
        // Case 2: Only one child (Left child missing)
        else if (root.right == null) {
            return root.left;
        }

        // Case 3: Two children
        // Get the inorder successor (smallest value in the right subtree)
        root.data = minValue(root.right);

        // Delete the inorder successor
        root.right = deleteNode(root.right, root.data);
    }

    return root;
}


// 1. Pre-Order Traversal (Root -> Left -> Right)
public static void preOrder(Node root) {
    if (root == null) return;
    System.out.print(root.data + " ");
    preOrder(root.leftChild);
    preOrder(root.rightChild);
}
// 2. In-Order Traversal (Left -> Root -> Right)
public static void inOrder(Node root) {
    if (root == null) return;
    inOrder(root.leftChild);
    System.out.print(root.data + " ");
    inOrder(root.rightChild);
}

// 3. Post-Order Traversal (Left -> Right -> Root)
public static void postOrder(Node root) {
    if (root == null) return;
    postOrder(root.leftChild);
    postOrder(root.rightChild);
    System.out.print(root.data + " ");
}

private static int minValue(Node root) {
    int minv = root.data;
    while (root.left != null) {
        minv = root.left.data;
        root = root.left;
    }
    return minv;
}


// 4. Calculate Tree Height (Maximum Depth)
public static int getHeight(Node root) {
    if (root == null) return -1; // Use 0 if a single node has a height of 1
    return 1 + Math.max(getHeight(root.leftChild), getHeight(root.rightChild));
}

// 5. Count Total Nodes in the Tree
public static int countNodes(Node root) {
    if (root == null) return 0;
    return 1 + countNodes(root.leftChild) + countNodes(root.rightChild);
}

// 6. Count Only Leaf Nodes (Nodes with no children)
public static int countLeaves(Node root) {
    if (root == null) return 0;
    if (root.leftChild == null && root.rightChild == null) return 1;
    return countLeaves(root.leftChild) + countLeaves(root.rightChild);
}
// 7. Find Maximum Value in a General Binary Tree
public static int findMax(Node root) {
    if (root == null) return Integer.MIN_VALUE;
    
    int max = root.data;
    int leftMax = findMax(root.leftChild);
    int rightMax = findMax(root.rightChild);
    
    return Math.max(max, Math.max(leftMax, rightMax));
}

// 8. Check if a Value Exists in the Tree
public static boolean contains(Node root, int target) {
    if (root == null) return false;
    if (root.data == target) return true;
    
    return contains(root.leftChild, target) || contains(root.rightChild, target);
}
    public static void main(String[] args){// main function for running the program 
        addChilds(75);


        addChilds(12);
        addChilds(42);
        addChilds(112);
        addChilds(122);
        addChilds(56);
        addChilds(79);
        addChilds(14);
        addChilds(49);
        addChilds(69);
        addChilds(751);
        

        // Print the tree structure to verify
        System.out.print("In-order Traversal: ");
        printTree(root);
        System.out.println();
    }
}
