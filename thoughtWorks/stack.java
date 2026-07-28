package thoughtWorks;
import java.util.*;

public class stack {

    private static void valitparenthesis(String s){
        Stack<Character> st=new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
            } 
            // Use 'else if' so opening brackets don't evaluate closing logic
            else if (c == ')' || c == ']' || c == '}') {
                // FIX 1: If stack is empty, there is no opening bracket to match
                if (st.isEmpty()) {
                    System.out.println("Not a valid parenthesis");
                    return;
                }
                
                char top = st.peek();
                if ((c == ')' && top == '(') || 
                    (c == ']' && top == '[') || 
                    (c == '}' && top == '{')) {
                    st.pop();
                } else {
                    // FIX 2: Mismatched brackets fail immediately to save time
                    System.out.println("Not a valid parenthesis");
                    return;
                }
            }
        }
        
        if (!st.isEmpty()) {
            System.out.println("Not a valid parenthesis");
            return;
        }
        System.out.println("a valid parenthesis");
    }

    private static int getPrecedence(char c){
        switch(c){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;

        }
        return -1;
    }
    private static void infixToPostfix(String s){

        StringBuilder sb=new StringBuilder();
        Stack<Character> st=new Stack<>();

        s=s.toLowerCase();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);

            if(c>='a' && c<='z'){
                sb.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while(!st.isEmpty() && st.peek()!='('){
                    sb.append(st.pop());
                }
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
            }
            else if(c=='+' || c=='-' || c=='*' || c=='/' || c == '^'){
                while(!st.isEmpty() && getPrecedence(c)<=getPrecedence(st.peek())){
                    sb.append(st.pop());
                }

                st.push(c);
            }

        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        System.out.println("Infix: " + s + " -> Postfix: " + sb.toString());
    }

    private static char[] reverseChar(char[] c){
        int low=0,high=c.length-1;

        while(low<high){
            char temp=c[low];
            c[low]=c[high];
            c[high]=temp;

            low++;high--;
        }

        return c;

    }
    private static void infixToPrefix(String s){
        s=s.toLowerCase();
        char c[]=reverseChar(s.toCharArray());
        Stack<Character> st=new Stack<>();
        StringBuilder sb=new StringBuilder();

        for(char i:c){
            if(i>='a' && i<='z'){
                sb.append(i);
            }else if(i=='('){
                st.push(i);
            }else if(i==')'){
                while(!st.isEmpty() && st.peek()=='('){
                    sb.append(st.pop());
                }

                if(st.peek()=='('){
                    st.pop();
                }
            }

            else if(i=='+' || i=='-' || i=='*' || i=='/' || i=='^'){
                while(!st.isEmpty() && prefixPrecedence(i)<=prefixPrecedence(st.peek())){
                    sb.append(st.pop());
                }

                st.push(i);
            }
        }

        while(!st.isEmpty()){
            sb.append(st.pop());
        }


        sb=sb.reverse();

        System.out.println("infix: "+s+ "---- and prefix Notation is : -----"+ sb.toString());
    }

    private static int prefixPrecedence(char ch){
        switch(ch){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
            
        }

        return -1;
    }
    public static void main(String args[]){

        // Testing Queue-based Stack
        System.out.println("--- Queue Stack Testing ---");
        stackUsingQueue s1 = new stackUsingQueue();
        s1.push(10);
        s1.push(20);
        s1.push(30);
        s1.display(); // Output: 30 20 10 
        s1.pop();     // Output: Deleted element is : 30
        s1.display(); // Output: 20 10 

        // Testing Array-based Stack
        System.out.println("\n--- Array Stack Testing ---");
        stackUsingArray s2 = new stackUsingArray();
        s2.push(100);
        s2.push(200);
        s2.display(); // Output: 100 200 
        s2.pop();     // Output: Deleted element is : 200
        s2.display(); // Output: 100 

        System.out.println("\n--- Infix to Postfix Testing ---");
        infixToPostfix("a+b");                  // Expected: ab+
        infixToPostfix("(a+b)*c");              // Expected: ab+c*
        infixToPostfix("a+b*c/d-e");            // Expected: abc*d/+e-
        infixToPostfix("((a+b)*(c-d))/(e+f)");  // Expected: ab+cd-*ef+/
        infixToPostfix("a^b^c");                // Expected: abc^^
    }
}

class stackUsingQueue{
    // queue: 1 2 3 4 5
    // q-pop: 1, s-pop: 5

    Queue<Integer> q1=new LinkedList<>();
    
    Queue<Integer> q2=new LinkedList<>();
    

    public  void push(int data){
       

        while(!q1.isEmpty()){

            q2.add(q1.remove());
        }
        
        q1.add(data);
        
        while(!q2.isEmpty()){

            q1.add(q2.remove());
        }
    }

    public  void pop(){
        if(q1.isEmpty()){
            System.out.println("Stack is underflow... ");
            return;
        }
        
        System.out.println("deleted element is : "+ q1.poll());
    }

    public  void display(){
        if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        for (int i : q1) { 
            System.out.print(i + " "); 
        } 
        System.out.println();
    }
    
}

class stackUsingArray{

    private int ptr=0;
    private int [] stArray=new int[100];

    public  void push(int data){
        if(ptr==stArray.length){
            System.out.println("Stack is overFlow... ");
            return;
        }
        stArray[ptr]=data;
        ptr++;
    }

    public  void pop(){
        if(ptr<=0){
            System.out.println("Stack is UnderFlow... ");
            return;
        }
        ptr--; 
        System.out.println("Deleted element is : " + stArray[ptr]);
        stArray[ptr] = 0; // Clean up reference
    }

    public  void display(){
        if (ptr == 0) {
            System.out.println("Stack is empty");
            return;
        }
        // Fixed: Loop only up to the active pointer index
        for (int i = 0; i < ptr; i++) { 
            System.out.print(stArray[i] + " "); 
        } 
        System.out.println();
    }

}
