public class thursday {

    private static void reverseArray(int[] arr){
        int low=0,high=arr.length-1;
        System.out.println("\n");
        System.out.print("before reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }

        while(low<high){
            int temp=arr[low];
            arr[low]=arr[high];
            arr[high]=temp;

            low++;high--;
        }
        System.out.println("");
        System.out.print("After reverse: ");
        for(int i:arr){
            System.out.print(i+" ");
        }

    }

    private static void palindromeString(String s){
        int low=0,high=s.length()-1;
        s=s.toLowerCase();
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                System.out.println("Given String is not a valid palindrome...");
                return;
            }

            low++;high--;
        }
        
        System.out.println("Given String is a valid palindrome...");
        
    }

    private static void removeDuplicatesFromSortedArray(int arr[]){
        int slow=0,index=1;

        System.out.print("Array with duplicates : ");
        for(int i:arr){
            System.out.print(i+" ");
        }
        System.out.println();
        for(int fast=1;fast<arr.length;fast++){
            if(arr[slow]!=arr[fast]){
                arr[index++]=arr[fast];
                slow=fast;
            }else{
                continue;
            }
        }
        System.out.print("Array withOut duplicates : ");
        for(int i=0;i<index;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5,6,7,8,15,18,20,25};
        //reverse Array
        reverseArray(arr); 

        System.out.println("\n");
        // palindrome
        palindromeString(new String("aman"));
        palindromeString(new String("aabaabaabaab"));
        palindromeString(new String ("aaaabbbccdccbbbaaaa"));
        palindromeString(new String("Naman")); 
        
        System.out.println("\n");

        //remove Duplicates from sorted Array

        removeDuplicatesFromSortedArray(new int[]{1,2,2,3,4,4,4,5,6,7,8,9,9,10,10,11,12,15,15,15,25});

        System.out.println();
    }
}

