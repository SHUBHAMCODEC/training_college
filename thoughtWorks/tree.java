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

    // Fixed: 'static' must be lowercase
    static Node root = null; 

    // Insert method using a helper loop or recursion
    private static void addChilds(int data) {
        Node newNode = new Node(data);
        if (root == null) {
            root = newNode;
            return;
        }

        Node current = root;
        Node parent = null;

        while (true) {
            parent = current;
            if (data < current.data) { // Go left
                current = current.leftChild;
                if (current == null) {
                    parent.leftChild = newNode;
                    return;
                }
            } else { // Go right
                current = current.rightChild;
                if (current == null) {
                    parent.rightChild = newNode;
                    return;
                }
            }
        }
    }
}
