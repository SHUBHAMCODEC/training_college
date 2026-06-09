import java.util.Stack;

public class queueUsing2Stack {
   
    static Stack<Integer> s1 = new Stack<>();
    static Stack<Integer> s2 = new Stack<>();

    static Stack<Integer> s3 = new Stack<>();
    static Stack<Integer> s4 = new Stack<>();

   
    public static void push(int i) {
        s1.push(i);
    }

   
    public static int pop() {
      
        if (s1.isEmpty() && s2.isEmpty()) {
            System.out.println("Queue is empty");
            return -1; 
        }       
        while (!s1.isEmpty()) {
                s2.push(s1.pop());
        }
       int k=s2.pop();

       Stack<Integer> temp=s1;
       s1=s2;
       s2=temp;

        
        return k;

       
      
    }

    private static void push2(int a){

        while(!s3.isEmpty()){
            s4.push(s3.pop());
        }

        s3.push(a);

        while(!s4.isEmpty()){
            s3.push(s4.pop());
        }
    }

    private static int pop2(){
        return s3.pop();

    }

    public static void main(String[] args) {
        push(10);
        push(20);
        push(30);

        System.out.println(pop()); // Outputs 10 (First In, First Out)
        System.out.println(pop()); // Outputs 20
        
        push(40);
        System.out.println(pop()); // Outputs 30
        System.out.println(pop()); // Outputs 40
    }
}