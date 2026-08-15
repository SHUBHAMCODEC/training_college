package thoughtWorks;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import thoughtWorks.revision.revtree;

public class fridayTree {

    private static int maxheight(revision.revtree root) {
        if (root == null) return 0;

        return Math.max(
            maxheight(root.left), maxheight(root.right)
        ) +1;
    }

    private static void levelOrder(revision.revtree root){
        if(root==null){
            return;
        }
        int p=0;
        Queue<revision.revtree> q1 = new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            int size=q1.size();
           
            System.out.print("Nodes at "+p+ " level: ");

            for(int i=0;i<size;i++){
                revision.revtree curr=q1.poll();
                System.out.print(curr.data+ " ");

                if(curr.left!=null){
                    q1.add(curr.left);
                }if(curr.right!=null){
                    q1.add(curr.right);
                }
            }
            p++;
            System.out.println();
        }
    }

    private static void invertChild(revision.revtree root){
        if(root==null){
            return;
        }
        revision.revtree temp=root.left;
        root.left=root.right;
        root.right=temp;

        invertChild(root.left);
        invertChild(root.right);

    }

    private static void minMaxinBST(revision.revtree root){
        
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        int[] result = {Integer.MAX_VALUE, Integer.MIN_VALUE};
        helper(result,root);

        System.out.println("Min: " + result[0] + ", Max: " + result[1]);

        System.out.println("--------2nd Method------------");

        int min2=Integer.MAX_VALUE;
        int max2=Integer.MIN_VALUE;

        revision.revtree curr=root;
        while(curr.left!=null){
            curr=curr.left;
        }
        min2=curr.data;
        curr=root;
        while(curr.right!=null){
            curr=curr.right;
        }
        max2=curr.data;

        System.out.println("Min: " + min2 + ", Max: " + max2);


    }
    private static void helper(int []result,revision.revtree root){
        if(root==null){
            return ;
        }
        if(root.data<result[0]){
            result[0]=root.data;
        }if(root.data>result[1]){
            result[1]=root.data;
        }

        helper(result, root.left);
        helper(result, root.right); 
    }
    private static void validBST(revision.revtree root){
        ArrayList<Integer> ls=new ArrayList<>();
        helper(ls, root);
        
        for(int i=0;i<ls.size();i++){
            if(ls.get(i)>=ls.get(i+1)){
                System.out.println("Not a valid BST...");
                return;
            }
        }
        System.out.println("Yes it's BST ...");
    }

    private static void helper(ArrayList<Integer> ls,revision.revtree root){
        if(root==null){
            return;
        }
        helper(ls, root.left);
        ls.add(root.data);
        helper(ls, root.right);
    }

    private static void inorderPredessorAndSuccessor(revision.revtree root, int target){
        ArrayList<Integer> ls=new ArrayList<>();

        helper(ls, root);

        for(int i=0;i<ls.size();i++){
            if(ls.get(i)==target){
                System.out.println("Inorder Predessor is: "+ ls.get(i-1));
                System.out.println("Inorder Successor is: "+ ls.get(i+1));
            }
        }

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

        System.out.println("Maximum depth of tree is : "+maxheight(revision.root));
        System.out.println();
        System.out.println("------------------- Level Order Traversal ---------------");
        levelOrder(revision.root);

        System.out.println("----------------------inverted child done---------------------");
        invertChild(revision.root);

        levelOrder(revision.root);

        System.out.println("---------------------MIN/MAX of BST -------------------");
        minMaxinBST(revision.root);

        System.out.println("----------------------Valid BST------------------");
        validBST(revision.root);

        System.out.println("---------------------inorder Predessor And Successor-----------");
        inorderPredessorAndSuccessor(revision.root, 22);
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
