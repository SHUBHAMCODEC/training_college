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
            root.left=creation(root.left,data);
        }else{
            root.right=creation(root.right, data);
        }
        return root;
    }

    private static Node delete(Node root,int target){// function to delete the specific node of tree -> recursive approch
        if(root==null){
            return null;
        }

        if(target<root.data){
            root.left=delete(root.left, target);
        }else if(target>root.data){
            root.right=delete(root.right, target);
        }else{

            if(root.left==null) return root.right;
            if(root.right==null)return root.left;

            //if deleting node has 2 children.

            root.data=minv(root.right);

            root.right=delete(root.right, root.data);
        }

        return root;
    }

    private static int minv(Node root){
        int min_value=root.data;
        while(root.left!=null){
            min_value=root.left.data;
            root=root.left;
        }
        return min_value;
    }

    private static void print(Node root){ //function for printing the nOdes of tree -> preOrder traversal printing.
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        print(root.left);
        print(root.right);
    }

    private static void printInorder(Node root){//inOrder traversal print
        if(root==null){
            return;
        }
        printInorder(root.left);
        System.out.print(root.data+" ");
        printInorder(root.right);
    }

    private static void printPostorder(Node root){//postorder traversal print
        if(root==null){
            return;
        }

        printPostorder(root.left);
        printPostorder(root.right);
        System.out.print(root.data+" ");
    }
    public static void main(String[] args) {
        root=creation(95);
    }
}
