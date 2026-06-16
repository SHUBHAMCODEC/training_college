package thoughtWorks;

import java.util.HashMap;

public class StringsAreRotationsOrNot {

    private static void helper(String s1, String s2){
        //Approch 1 -> string function

        String s3=s1+s1;
        if (s3.contains(s2)) {
            System.out.println("Yes, it is a rotation");
        } else {
            System.out.println("No, it is not a rotation");
        }

        //approch 2 -> hashSet

        HashMap<Character,Integer> set1=new HashMap<>();
        HashMap<Character,Integer> set2=new HashMap<>();
        for(char c:s1.toCharArray()){
            set1.put(c,set1.getOrDefault(c, 0)+1);
        }for(char c:s2.toCharArray()){
            set2.put(c,set2.getOrDefault(c, 0)+1);
        }
        int flag=0;
        for(char c:s1.toCharArray()){
            if(set1.get(c)!=set2.get(c)){
                System.out.println("not a roation: 2 ");
                flag=-1;
                break;
            }
        }if(flag==0){System.out.println("approch 2 yes");}
        


        //approch 3 -> using anagram array

        int arr[]=new int[26];

        for(char c:s1.toCharArray()){
            arr[c-'a']+=1;
        }
        for(char c:s2.toCharArray()){
            arr[c-'a']-=1;
        }

        for(int c:arr){
            if(c!=0){
                System.out.println("not a roation:3 ");
                break;
            }
        }

        System.out.println("approch 3 yes");
    }

    public static void main(String[] args){
        helper(new String("rotation"), new String("tionorap"));
    }
}
