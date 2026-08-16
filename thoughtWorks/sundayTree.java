package thoughtWorks;

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
            }else{
                int min=getMin(curr.right);
                curr.data=min;
                curr.right=delete(curr.right, target);
            }
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
    static tree root2=null;
    private static void normalToBST(tree curr){
        if(curr==null){
            root2=curr;
        }
        normalToBST(curr.left);
        normalToBST(curr.right);

    }
}
