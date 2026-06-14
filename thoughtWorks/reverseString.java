package thoughtWorks;
import java.util.*;
public class reverseString {
    private static void helper(String str){

         char[] s=str.toCharArray();
         int low=0,high=s.length-1;

         while(low<high){
            char temp=s[low];
            s[low]=s[high];
            s[high]=temp;
            low++;high--;
         }

         System.out.println("reverse String : "+new String(s));
    }
    

    private static boolean helper2(String str){
        char[] ch=str.toCharArray();
        int low=0,high=ch.length-1;
        while(low<=high){
           if(ch[low]!=ch[high]){
            return false;
           }
            low++;high--;
        }
        return true;
    }

    private static void duplicates(String str){
        HashMap<Character,Integer> map=new HashMap<>();
        char c='n';
        for(char ch:str.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<str.length();i++){
            c=str.charAt(i);
            if(map.get(c)>1){
                System.out.println("First duplicate Character is : "+ c);
                return;
            }
        }

    }

    public static void main(String[] args){
        String s=new String("Shubham");

        helper(s);

       System.out.println( helper2(s));
        String s2=new String("naman");
        System.out.println(helper2(s2));

        duplicates(s);
        duplicates(s2);
    }
}
