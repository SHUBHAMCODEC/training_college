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

        for(Map.Entry<Character,Integer>e:mpp.entrySet()){
            if(e.getValue()==1){
                System.out.println("First_Non_Repeating_Character :"+ e.getKey());
            }
        }
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
        StringBuilder sb=new StringBuilder();
        int cnt=0;
        char c[]=s.toCharArray();
        for(int i=0;i<c.length;i++){
            cnt+=1;
            if(c[i]==c[i+1]){
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
        for(int i=2;i<Math.sqrt(n);i++){
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
    
    
    public static void main(String[] args) {
        
    }
}
