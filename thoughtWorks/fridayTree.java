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
    btree curr=root;
    public btree delete(btree curr,int target){
        if (curr == null) {
            return null; 
        }
        if (target < curr.data) {
            curr.left = delete(curr.left, target);
        } else if (target > curr.data) {
            curr.right = delete(curr.right, target);
        } 
        else {
            if (curr.left == null) {
                return curr.right; 
            }
            else if (curr.right == null) {
                return curr.left;
            }
            curr.data = minValue(curr.right);
            curr.right = delete(curr.right, curr.data);
        }
        return curr;
    }
    private int minValue(btree curr) {
        int minv = curr.data;
        while (curr.left != null) {
            minv = curr.left.data;
            curr = curr.left;
        }
        return minv;
    }

    public void search(btree curr,int item){
        if(curr==null){
            System.out.println(item + " is not in the tree!");
        }
        if(curr.data==item){
            System.out.println(item + " is in the tree!");
        
            return;
        }
        if(item<curr.data){
            search(curr.left, item);
        }else{

            search(curr.right, item);
        }

       
         }


}
