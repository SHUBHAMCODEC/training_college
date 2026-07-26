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

        private static void infixTopreFix(String s){

            Stack<Character> st0=new Stack<>();
            s=s.toLowerCase();
            char[] cr=s.toCharArray();
            for(int i=0;i<cr.length;i++){
                if(cr[i]>='a' && cr[i]<='z'){
                    st0.push(cr[i]);
                }else{
                    if(i<cr.length){
                        char ctemp=st0.peek();
                        char nextOfith=cr[i+1];
                        char c=(ctemp+nextOfith+cr[i])
                        st.push(c);
                    }

                }
            }

            System.out.println("postFix Notation of given prefix: "+s+" is : "+ st.peek());

        }
        
        if (!st.isEmpty()) {
            System.out.println("Not a valid parenthesis");
            return;
        }
        System.out.println("a valid parenthesis");
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
