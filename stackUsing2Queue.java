import java.util.LinkedList;
import java.util.Queue;

public class stackUsing2Queue {
     static Queue<Integer> q1 = new LinkedList<>();
     static Queue<Integer> q2 = new LinkedList<>();

     private static void push(int i){
        q1.add(i);
     }

     private static int pop(){

         if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1;
        }

        while(q1.size()>1){
            q2.add(q1.remove());
        }

        int k=q1.remove();
        
        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;
        System.out.println(q1);

        return k;
        
     }

     private static int peek(){

         if (q1.isEmpty()) {
            System.out.println("Stack is empty");
            return -1 ;
        }

        while(q1.size()>1){
            q2.add(q1.remove());
        }

        int k=q1.peek();
        q2.add(q1.remove());

        Queue<Integer> temp=q1;
        q1=q2;
        q2=temp;

        return k;
     }

    public static void main(String[] args) {
        push(10);
            push(20);
            push(30);

            System.out.println(pop());  // Outputs 30 (Last In, First Out)
            System.out.println(peek()); // Outputs 20 (Shows top item)
            System.out.println(pop());  // Outputs 20
    }
     

}
