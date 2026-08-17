package thoughtWorks;

import java.util.ArrayList;
import java.util.Collections;

public class sundayTree {
    static class tree{
        tree left;
        int data;
        tree right;

        tree(int data){
            this.left=null;
            this.data=data;
            this.right=null;
        }
    }
    static tree root=null; 
    static int ptr=0;
    private static void creation(int arr[]){
        root=new tree(arr[0]);
        for(int i:arr){
            if(ptr==0){
                root.left=new tree(i);
            }if(ptr==1){
                root.right=new tree(i);
            }else{
                ptr=0;
            }
        }
    }

    
    private static tree delete(tree curr,int target){
        
        if(curr==null){
            return null;
        }

        if(target<curr.data){
            curr.left=delete(curr.left, target);
        }if(target>curr.data){
            curr.right=delete(curr.right, target);
        }else{
            if(curr.left!=null){
                return curr.left;
            }if(curr.right!=null){
                return curr.right;
            }
                int min=getMin(curr.right);
                curr.data=min;
                curr.right=delete(curr.right, target);
            
        }

        return curr;
    }

    private static int getMin(tree curr){
        int value=curr.data;
        while(curr.left!=null){
            curr=curr.left;
            value=curr.data;
        }

        return value;
    }

    
    static tree rootBST=null;
    private static void normalToBST(tree curr){
       ArrayList<Integer> ls=new ArrayList<>();
       ls=inorder(curr, ls);
       Collections.sort(ls);

       for(int i=0;i<ls.size();i++){
          helper(curr,ls.get(i));  
       }
      rootBST=curr;

    }

    
    private static ArrayList<Integer> inorder(tree curr,ArrayList<Integer> ls){
        if(curr==null){
            return null;
        }
        inorder(curr.left, ls);
        ls.add(curr.data);
        inorder(curr.right, ls);
        return ls;
    }

    private static tree helper(tree curr,int value){
        if(curr==null){
            return new tree(value);
        }

        if(value<curr.data){
            curr.left=helper(curr.left, value);
        }else{
            curr.right=helper(curr.right, value);
        }

        return curr;
    }

    private static void validBST(tree rootBST){
        System.out.println("/----------- Checking the tree is now BST or not --------------/");
        tree curr2=rootBST;
        ArrayList<Integer> lt=new ArrayList<>();
        lt=inorder(curr2, lt);

        for(int i=0;i<lt.size();i++){
            if(lt.get(i)>lt.get(i+1)){
                System.out.println(" given tree is not valid BST ...");
                return;
            }
        }

        System.out.println(" given tree is a valid BST Tree ...");
    }
}
