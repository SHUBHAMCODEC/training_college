import java.util.HashMap;
import java.util.Map;

public class tuesday {
    

    private static void reverseString(String s){
        char[] c=s.toCharArray();
        int low=0,high=c.length-1;
        while(low<high){
            char temp=c[low];
            c[low]=c[high];
            c[high]=temp;


            low++;high--;
        }
        System.out.println("Original string: "+ s);
        System.out.println("Reverse string: "+new String(c));
    }

    private static void palindromeString(String s){
        int low=0,high=s.length()-1;
        while(low<high){
            if(s.charAt(low)!=s.charAt(high)){
                System.out.println("Not a palindrome... ");
                return;
            }
            low++;high--;
        }
        System.out.println("its is palindrome string.... ");
    }

    private static void palindromeInteger(int n){
        int copy=n;
        int newdata=0;
        while(n>0){
            int temp=n%10;
            newdata=newdata*10+temp;
            n/=10;
        }

        if(newdata==copy){
            System.out.println("number is Palindrome");
            return;
        }else{
            System.out.println("not a palindromic number");
        }
    }

    private static void countConsonentandVowels(String s){
        int con_count=0,vow_count=0;

        for(char ch:s.toCharArray()){
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
                vow_count++;
            }else{
                con_count++;
            }
        }

        System.out.println("vowels count are "+ vow_count+" and consonents count are: "+ con_count);
    }

    private static void convertLowerToUppercase(String s){
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            if (c[i] >= 'a' && c[i] <= 'z') { // Ensure it only modifies lowercase letters
                c[i] = (char) (c[i] - 32);     // Correct cast syntax and ASCII offset
            }
        }
        System.out.println(new String(c));    // Print or return the converted string
    }

    private static void RemoveSpace(String s){
        StringBuilder sb=new StringBuilder();

        for(char ch:s.toCharArray()){
            if(ch!=' '){
                sb.append(ch);
            }
        }

        System.out.println("String without space : "+ sb.toString());
    }

    private static void countFrequency(String s){
        HashMap<Character,Integer> mpp=new HashMap<>();
        for(char ch:s.toCharArray()){
            mpp.put(ch,mpp.getOrDefault(ch, 0)+1);
        }

        for(Map.Entry<Character,Integer>e:mpp.entrySet()){
            System.out.println("Character: " + e.getKey() + ", Count: " + e.getValue());
        }
    }

    private static void anagram(String s,String t){
        if (s.length() != t.length()) { // FIXED: Basic length mismatch validation
            System.out.println(s + " and " + t + " are not anagrams (length mismatch).");
            return;
        }

        char[] c1=new char[26];

        for(int i=0;i<s.length();i++){
            c1[(s.charAt(i))-'a']+=1;
        }
        for(int i=0;i<t.length();i++){
            c1[(t.charAt(i))-'a']-=1;
        }

        for(int i=0;i<c1.length;i++){
            if(c1[i]!=0){
                System.out.println("strings are not anagram in nature...");
                return;
            }
        }

        System.out.println("Strings are not anagram in nature... ");

    }

    private static void First_Non_Repeating_Character(String s){
        HashMap<Character,Integer>mpp=new HashMap<>();

        for(char i:s.toCharArray()){
            mpp.put(i,mpp.getOrDefault(i, 0)+1);
        }

         for(char ch : s.toCharArray()) {
            if(mpp.get(ch) == 1) {
                System.out.println("First_Non_Repeating_Character in " + s + " is: " + ch);
                return;
            }
        }
        System.out.println("First_Non_Repeating_Character in " + s + " is: None");
    }

    private static void Longest_Common_Prefix(String[] s) {
        StringBuilder sb = new StringBuilder();
    
        if (s == null || s.length == 0) {
            System.out.println("Longest Common Prefix: ");
            return;
        }
    
        for (int i = 0; i < s[0].length(); i++) {
            char c = s[0].charAt(i);
    
            for (int j = 1; j < s.length; j++) {
                
                if (i >= s[j].length() || c != s[j].charAt(i)) {
                    System.out.println("Longest Common Prefix: " + sb.toString());
                    return;
                }
            }
            sb.append(c);
        }
        
        
        System.out.println("Longest Common Prefix: " + sb.toString());
    }
    private static void String_Compression(String s){
        if (s == null || s.isEmpty()) {
            System.out.println("String Compression: ");
            return;
        }
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            cnt+=1;
            if(i + 1 < c.length && c[i]==c[i+1]){
                continue;
            }else{
                sb.append(c[i]);
                sb.append(cnt);
                cnt=0;
            }
        }

        System.out.println("String Compression: "+ sb.toString());
    }

    private static boolean Check_Prime_Number(int n){
        if (n <= 1) return false;
        for(int i=2;i<=Math.sqrt(n);i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }

    private static void allFactors(int n){
        for(int i=1;i<=n;i++){
            if(n%i==0){
               System.out.print(i+" "); 
            }
        }
    }

    private static void GCD(int a, int b){
        while(b!=0){
            int remainder=a%b;
            a=b;
            b=remainder;
        }
        System.out.println("greatest common divisor (GCD): "+ a);
    }

    private static int LCM(int a, int b){
        if (a == 0 || b == 0) {
            return 0; 
        }
        
        // Store original values to compute LCM later
        int num1 = Math.abs(a);
        int num2 = Math.abs(b);
        
        // Inline Euclid's algorithm to find GCD
        while (num2 != 0) {
            int remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        int gcd = num1;
        
        // Calculate LCM using the original values
        return Math.abs(a) / gcd * Math.abs(b);
    }
    
    private static boolean Check_Armstrong_Number(int n){
        int temp=0;
        int dup=n;
        while(n>0){
            int t=n%10;
            temp+=t*t*t;
            n=n/10;
        }

        if(temp==dup){
            return true;
        }
        return false;
    }

    private static int fibonacci(int n){
        
        if(n==0 || n==1){
            return n;
        }
        return (fibonacci(n-1)+ fibonacci(n-2));

    }
    public static void main(String[] args) {
        System.out.println("--- 1. Reverse String ---");
        reverseString("java");

        System.out.println("\n--- 2. Palindrome String ---");
        palindromeString("radar");
        palindromeString("hello");

        System.out.println("\n--- 3. Palindrome Integer ---");
        palindromeInteger(121);
        palindromeInteger(123);

        System.out.println("\n--- 4. Count Vowels & Consonants ---");
        countConsonentandVowels("Hello World!");

        System.out.println("\n--- 5. Convert Lowercase to Uppercase ---");
        convertLowerToUppercase("programming123");

        System.out.println("\n--- 6. Remove Spaces ---");
        RemoveSpace(" J a v a   S t a c k ");

        System.out.println("\n--- 7. Count Character Frequencies ---");
        countFrequency("apple");

        System.out.println("\n--- 8. Anagram Validation ---");
        anagram("silent", "listen");
        anagram("hello", "world");

        System.out.println("\n--- 9. First Non-Repeating Character ---");
        First_Non_Repeating_Character("swiss");
        First_Non_Repeating_Character("aabbc");

        System.out.println("\n--- 10. Longest Common Prefix ---");
        String[] words = {"flower", "flow", "flight"};
        Longest_Common_Prefix(words);

        System.out.println("\n--- 11. String Compression ---");
        String_Compression("aabcccccaaa");

        System.out.println("\n--- 12. Prime Check ---");
        System.out.println("Is 9 prime? " + Check_Prime_Number(9));
        System.out.println("Is 17 prime? " + Check_Prime_Number(17));

        System.out.println("\n--- 13. Output All Factors ---");
        allFactors(24);

        System.out.println("\n--- 14. GCD Calculation ---");
        GCD(48, 18);

        System.out.println("\n--- 15. LCM Calculation ---");
        System.out.println("LCM of (12, 18): " + LCM(12, 18));

        System.out.println("\n--- 16. Armstrong Number Check ---");
        System.out.println("Is 153 Armstrong? " + Check_Armstrong_Number(153));
        System.out.println("Is 123 Armstrong? " + Check_Armstrong_Number(123));

        System.out.println("\n--- 17. Fibonacci Term Retrieval ---");
        System.out.println("Fibonacci term at index 6: " + fibonacci(6));
    }
}
