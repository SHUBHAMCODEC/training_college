package thoughtWorks;

public class fridayTree {
    
}

class binaryTree{
    static class btree{
        btree left;
        int data;
        btree right;

        btree(int data){
            this.left=null;
            this.data=data;
            this.right=null;
        }
    }
    static btree root=null;
    public void addElement(int data){
        
       root=insert(root,data);
    }

    public btree insert(btree current,int data){
        if(current==null){
            return new btree(data);
        }

        if(data<current.data){
            current.left=insert(current.left, data);
        }
        else{
            current.right=insert(current.right, data);
        }

        return current;

    }

    
    public void display(){
        System.out.print("Inorder traversal");
        inorderTraversal(root);
        System.out.println();
        System.out.print("preorder traversal");
        preorderTraversal(root);
        System.out.println();
        System.out.print("postorder traversal");
        postorderTraversal(root);
    }

    public void inorderTraversal(btree curr){
        if(curr==null){
            return;
        }

        inorderTraversal(curr.left);
        System.out.print(curr.data+" ");
        inorderTraversal(curr.right);
    }
    public void preorderTraversal(btree curr){
        if(curr==null){
            return;
        }

        System.out.print(curr.data+" ");
        preorderTraversal(curr.left);
        preorderTraversal(curr.right);
    }
    public void postorderTraversal(btree curr){
        if(curr==null){
            return;
        }

        postorderTraversal(curr.left);
        
        postorderTraversal(curr.right);
        System.out.print(curr.data+" ");
    }

    public void delete(int target){

    }
    public void search(int item){
        for
    }


}
