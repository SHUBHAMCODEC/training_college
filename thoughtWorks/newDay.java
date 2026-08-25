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

    
    public static void main(String[] args) {
            CountAllDigit(4578962);
    }
}
