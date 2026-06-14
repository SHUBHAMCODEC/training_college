package thoughtWorks;

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

         System.out.println(new String(s));
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

    public static void main(String[] args){
        String s=new String("Shubham");

        helper(s);

       System.out.println( helper2(s));
        String s2=new String("naman");
        System.out.println(helper2(s2));
    }
}
