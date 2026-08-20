package thoughtWorks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

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
       rootBST=null;
       for(int i=0;i<ls.size();i++){
          rootBST=helper(rootBST, ls.get(i)); 
       }

    }

    
    private static ArrayList<Integer> inorder(tree curr,ArrayList<Integer> ls){
        if(curr==null){
            return ls;
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
        if (rootBST == null) {
            System.out.println("Tree is empty!");
            return;
        }

        ArrayList<Integer> lt = new ArrayList<>();
        lt = inorder(rootBST, lt);

        for(int i=0;i<lt.size()-1;i++){
            if(lt.get(i)>lt.get(i+1)){
                System.out.println(" given tree is not valid BST ...");
                return;
            }
        }

        System.out.println(" given tree is a valid BST Tree ...");
    }

    tree first;
    tree second;
    tree prev;
     public static List<List<Integer>> helper(TreeNode root,List<List<Integer>> ls){
         if (root == null) {
            return ls;
        }
        Queue<TreeNode> q1=new LinkedList<>();
        q1.add(root);
        while(!q1.isEmpty()){
            List<Integer> sub=new ArrayList<>();
            int size=q1.size();

            for(int i=0;i<size;i++){
                TreeNode curr=q1.poll();
                sub.add(curr.val);

                if(curr.left!=null){
                    q1.add(curr.left);
                }if(curr.right!=null){
                    q1.add(curr.right);
                }
            }
            ls.add(sub);
        }

        return ls;
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ls=new ArrayList<>();
        helper(root,ls);

        return ls;
    }

    private static ArrayList<Integer> helper(TreeNode root,ArrayList ls){
        if(root==null){
            return ls;
        }
        helper(root.left,ls);
        ls.add(root.val);
        helper(root.right,ls);

        return ls;
    }
    public boolean isValidBST(TreeNode root) {
        ArrayList<Integer> ls=new ArrayList<>();
        helper(root,ls);
        for(int i=0;i<ls.size()-1;i++){
            if(ls.get(i)>=ls.get(i+1)){
                return false;
            }
        }

        return true;
    }
    public void recoverTree(TreeNode root) {
        helper(root);
        // Swap the values of the two misplaced nodes
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }

    void helper(TreeNode node) {
        if (node == null) return;

        // Traverse left subtree
        helper(node.left);

        // Detect swapped nodes
        if (prev != null && prev.val > node.val) {
            if (first == null) {
                first = prev;
            }
            second = node;
        }

        prev = node;

        // Traverse right subtree
        helper(node.right);
    }
    public static void main(String[] args) {
        
    }
}
