package thoughtWorks;

public class treebasics {
    
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
            creation(root.left,data);
        }else{
            creation(root.right, data);
        }
        return root;
    }

    private static Node delete(Node root,int target){// function to delete the specific node of tree -> recursive approch

        if(root.data==target){
            return root=null;
        }

        if(target<root.data){
            delete(root.left, target);
        }else{
            delete(root.right, target);
        }
        return root;
    }

    private static void print(Node root){ //function for printing the nOdes of tree -> preOrder traversal printing.
        if(root==null){
            return;
        }
        System.out.print(root.data);
        print(root.left);
        print(root.right);
    }

    private static void printInorder(Node root){//inOrder traversal print
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data);
        printInorder(root.right);
    }

    private static void printPostorder(Node root){//postorder traversal print
        if(root==null){
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data);
    }
    public static void main(String[] args) {
        root=creation(95);
    }
}
