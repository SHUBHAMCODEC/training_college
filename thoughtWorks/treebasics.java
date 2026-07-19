package thoughtWorks;

public class treebasics {
    
    static class Node{
        Node left;
        int data;
        Node right;

        Node(int data){
            this.left=this.right=null;
            this.data=data;
        }
    }

    static Node root=null;
    private static Node creation(Node root,int data){
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

    private static Node delete(Node root,int target){

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

    private static void print(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data);
        print(root.left);
        print(root.right);
    }
    public static void main(String[] args) {
        root=creation(95);
    }
}
