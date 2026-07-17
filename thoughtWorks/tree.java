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
