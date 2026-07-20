package thoughtWorks;

public class uniqueBST {

    
    static class Node{// tree structure for tree 
        Node left;
        int data;
        Node right;

        Node(int data){
            this.left=this.right=null;
            this.data=data;
        }
    }

    static Node root=null;

    private static Node creation(Node root,int data){// function to create nodes of tree
        if(root==null){
            return new Node(data);
        }
        if(data<root.data){
            root.left=creation(root.left,data);
        }else{
            root.right=creation(root.right, data);
        }
        return root;
    }


    public int numTrees(int n) {
        int[] uniqTree = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            uniqTree[i] = 1;
        }

        for (int nodes = 2; nodes <= n; nodes++) {
            int total = 0;
            for (int root = 1; root <= nodes; root++) {
                total += uniqTree[root - 1] * uniqTree[nodes - root];
            }
            uniqTree[nodes] = total;
        }

        return uniqTree[n];        
    }
    public static void main(String[] args) {
        uniqueBST solver = new uniqueBST();
        
        // Test cases
        int test1 = 3;
        int test2 = 4;
        int test3=9;
        int test4=18;
        
        System.out.println("Unique BSTs for " + test1 + " nodes: " + solver.numTrees(test1)); // Output: 5
        System.out.println("Unique BSTs for " + test2 + " nodes: " + solver.numTrees(test2)); // Output: 14
        System.out.println("Unique BSTs for " + test3 + " nodes: " + solver.numTrees(test3)); // Output: 4862
        System.out.println("Unique BSTs for " + test4 + " nodes: " + solver.numTrees(test4)); // Output: 477638700
    }
}
