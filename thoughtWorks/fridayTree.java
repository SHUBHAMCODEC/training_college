package thoughtWorks;



public class fridayTree {

    private static int maxheight(revision.revtree root) {
        if (root == null) return 0;
        
        return Math.max(
            maxheight(root.left), maxheight(root.right)
        ) + 1;
    }
    public static void main(String[] args) {
        revision sv=new revision();
        
        sv.creation(new int []{10,5,4,8,7,24,15,13,16,19,22,26,28,75,30,50,42,41,49});
        sv.display();
        sv.search(75); sv.search(15); sv.search(49); sv.search(99); sv.search(199); sv.search(11);
        
        
        revision.root=sv.delete(revision.root, 28);
        revision.root=sv.delete(revision.root, 19);
        revision.root=sv.delete(revision.root, 42);

        sv.search(28);
        sv.search(49);
        sv.search(42);
    }
}

// class binaryTree{
//     static class btree{
//         btree left;
//         int data;
//         btree right;

//         btree(int data){
//             this.left=null;
//             this.data=data;
//             this.right=null;
//         }
//     }
//     static btree root=null;
//     public void addElement(int data){
        
//        root=insert(root,data);
//     }

//     public btree insert(btree current,int data){
//         if(current==null){
//             return new btree(data);
//         }

//         if(data<current.data){
//             current.left=insert(current.left, data);
//         }
//         else{
//             current.right=insert(current.right, data);
//         }

//         return current;

//     }

    
//     public void display(){
//         System.out.print("Inorder traversal");
//         inorderTraversal(root);
//         System.out.println();
//         System.out.print("preorder traversal");
//         preorderTraversal(root);
//         System.out.println();
//         System.out.print("postorder traversal");
//         postorderTraversal(root);
//     }

//     public void inorderTraversal(btree curr){
//         if(curr==null){
//             return;
//         }

//         inorderTraversal(curr.left);
//         System.out.print(curr.data+" ");
//         inorderTraversal(curr.right);
//     }
//     public void preorderTraversal(btree curr){
//         if(curr==null){
//             return;
//         }

//         System.out.print(curr.data+" ");
//         preorderTraversal(curr.left);
//         preorderTraversal(curr.right);
//     }
//     public void postorderTraversal(btree curr){
//         if(curr==null){
//             return;
//         }

//         postorderTraversal(curr.left);
        
//         postorderTraversal(curr.right);
//         System.out.print(curr.data+" ");
//     }
//     btree curr=root;
//     public btree delete(btree curr,int target){
//         if (curr == null) {
//             return null; 
//         }
//         if (target < curr.data) {
//             curr.left = delete(curr.left, target);
//         } else if (target > curr.data) {
//             curr.right = delete(curr.right, target);
//         } 
//         else {
//             if (curr.left == null) {
//                 return curr.right; 
//             }
//             else if (curr.right == null) {
//                 return curr.left;
//             }
//             curr.data = minValue(curr.right);
//             curr.right = delete(curr.right, curr.data);
//         }
//         return curr;
//     }
//     private int minValue(btree curr) {
//         int minv = curr.data;
//         while (curr.left != null) {
//             minv = curr.left.data;
//             curr = curr.left;
//         }
//         return minv;
//     }

//     public void search(btree curr,int item){
//         if(curr==null){
//             System.out.println(item + " is not in the tree!");
//         }
//         if(curr.data==item){
//             System.out.println(item + " is in the tree!");
        
//             return;
//         }
//         if(item<curr.data){
//             search(curr.left, item);
//         }else{

//             search(curr.right, item);
//         }

       
//          }


// }


//--------------------------------------REVISION-----------------------------------------//

class revision{
    static class revtree{
        revtree left;
        int data;
        revtree right;

        revtree(int data){
            this.left=null;
            this.data=data;
            this.right=null;
        }
    }
    static revtree root= null;
    
    public void creation(int[] arr){
        
        for(int i:arr){
            root=insert(root,i);
        }
    }

    public revtree insert(revtree curr,int a){
        if(curr==null){
            return new revtree(a);
        }

        if(a<curr.data){
            curr.left=insert(curr.left, a);
        }else{
            curr.right=insert(curr.right, a);
        }

        return curr;
    }

    public revtree delete(revtree root,int target){
        revtree curr=root;
        if(curr==null){
            return null;
        }

        if(target<curr.data){
           curr.left= delete(curr.left, target);
        }else if(target>curr.data){
            curr.right=delete(curr.right, target);
        }else{
            if(curr.left==null){
                return curr.right;
            }
            else if(curr.right== null){
                return curr.left;
            }
            
            int minValue=minVal(curr.right);
            curr.data=minValue;
            curr.right=delete(curr.right, minValue);
            
        }

        return curr;
    }

    public int minVal(revtree current){
        int value=current.data;
        while(current.left!=null){
            current=current.left;
            value=current.data;
        }

        return value;
    }


    public void display(){
        revtree curr=root;
        System.out.print("Inorder Traversal display: ");
        inorder(curr);
        System.out.println("\n");

        System.out.print("preorder Traversal display: ");
        preorder(curr);
        System.out.println("\n");
        
        System.out.print("postorder Traversal display: ");
        postorder(curr);
        System.out.println("\n");
    }

    public void inorder(revtree curr){
        if(curr == null){
            return; // Just return quietly without printing "Null"
        }
        inorder(curr.left);
        System.out.print(curr.data + " ");
        inorder(curr.right);
    }
    public void preorder(revtree curr){
        if(curr==null){
            return;
        }
        System.out.print(curr.data+" ");
        preorder(curr.left);
        preorder(curr.right);
    }
    public void postorder(revtree curr){
        if(curr==null){
            return;
        }

        postorder(curr.left);
        postorder(curr.right);
        System.out.print(curr.data+" ");
    }

    public void search(int value){
        revtree curr=root;
        mainSearch(curr, value);
        
    }

    public void mainSearch(revtree curr,int value){
        if(curr==null){
            System.out.println("data not found...");
            return;
        }
        if(curr.data==value){
            System.out.println("data is found...");
            return;
        }

        if(value<curr.data){
            mainSearch(curr.left, value);
        }else{
            mainSearch(curr.right,value);
        }

        
    }

}
