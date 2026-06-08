import java.util.*;

public class commonIn3Sorted{



    private static void helper(int a[],int b[],int c[]){

        int i=0, j=0, k=0;
        ArrayList<Integer> ls=new ArrayList<>();
        int lastAdded=Integer.MIN_VALUE;

        while(i<a.length && j<b.length && k<c.length){
            if(a[i]==b[j] && b[j]==c[k]){
                if(a[i]!=lastAdded){
                    ls.add(a[i]);
                    lastAdded=a[i];
                }

                i++;j++;k++;
            }

            else{
                if(a[i]<b[j] && a[i]<c[k]){
                    i++;

                }else if(b[j]<c[k] && b[j]<a[i]){
                    j++;
                }else{
                    k++;
                }
            }
        }

        System.out.println(ls);

    }   
    public static void main(String[] args){
        int a[]=/*{1, 5, 10, 20, 40, 80};*/             {1, 2, 3, 4, 5};
        int b[]=/*{6, 7, 20, 80, 100};*/                {7,10,14};
        int c[]=/*{3, 4, 15, 20, 30, 70, 80, 120};*/    {14,78,99,100,15};
        helper(a,b,c);
    }
}