package thoughtWorks;

import java.util.ArrayList;

public class newDay {

    private static void CountAllDigit(int n){
        int sum=0;
        while(n>0){
            n/=10;
            sum++;
        }

        System.out.println(" Total digit of Number is : "+ sum);
    }

    private static void reverseNumber(int n){
        int dummy=n;
        int rev=0;
        while(n>0){
            rev=rev*10+(n%10);
            n/=10;
        }

        System.out.println("Original Number: "+ dummy);
        System.out.println("Reverse Number: "+ rev);

    }
    private static void palindrome(int n){
        int dummy=n;
        int rev=0;
        while(n>0){
            rev=rev*10+(n%10);
            n/=10;
        }
        if(rev==dummy){
            System.out.println("Given Number is Palindrome in nature...");
        }else{
            System.out.println("Given Number is NOTT Palindrome in nature...");
        }
    }
    
    private static void ArmStrong(int n){
        int dummy=n;
        int mul=1;
        while(n>0){
            int temp=n%10;
            mul+=Math.pow(temp, 3);
            n/=10;
        }
    }

    private static void printALLDivisors(int n){
        ArrayList<Integer> ls=new ArrayList<>();
        ls.add(1);
        for(int i=2;i <=n/2;i++){
            if(n%1==0){
                ls.add(i);
            }
        }
        ls.add(n);

        System.out.println("All Divisors of given number is: "+ ls);
    }
    private static void CheckPrime(int n){
        boolean flag=true;

        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                flag=false;
            }
        }

        if(flag==true){
            System.out.println("Given Number is Prime in nature...");
        }else{
            System.out.println("Given Number is NOTT Prime in nature...");
        }
    }

    private static void recurName(String s,int n){
        if(n==0){
            return;
        }
        System.out.print(s+" ");
        recurName(s, n-1);
    }
    private static void recur1ToN(int i,int n){
        if(i==n+1){
            return;
        }
        System.out.print(i+" ");
        recur1ToN(i+1, n);
    }
    private static void recurNto1(int n){
        if(n==0){
            return;
        }
        System.out.print(n+" ");
        recurNto1(n-1);
    }
    private static void recurSumofN(int n,int sum){
        if(n==0){
            System.out.println(" sum is of First N number is: "+ sum);
            return;
        }
        sum+=n;
        recurSumofN(n-1, sum);
    }
    
    private static void recurFactorialofN(int n,int fact){
        if(n==0){
            System.out.println(" sum is of First N number is: "+ sum);
            return;
        }
        fact*=n;
        recurFactorialofN(n-1, fact);
        
    }
    private static void reverseArray(int[] arr,int i){
        if (i >= arr.length / 2) {
            return; 
        }
        
        // Calculate the exact matching index on the opposite side
        int mirrorIndex = arr.length - 1 - i;
        
        // Perform an actual in-place swap on the array
        int temp = arr[i];
        arr[i] = arr[mirrorIndex];
        arr[mirrorIndex] = temp;
        
        // Recursive call for the next pair
        reverseArray(arr, i + 1);

    }

    public static void main(String[] args) {
            CountAllDigit(4578962);
    }
}
