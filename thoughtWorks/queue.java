package thoughtWorks;

import java.util.ArrayList;

/**
 * queue
 */
public class queue {
    public static void main(String[] args) {
        // Test Stack-based Queue
        System.out.println("--- Testing Queue Using Stacks ---");
        queueUsingStack qStack = new queueUsingStack();
        qStack.push(10);
        qStack.push(20);
        qStack.push(30);
        qStack.display(); // Output: 10 20 30
        qStack.delete();  // Output: data deleted is :10
        qStack.display(); // Output: 20 30

        // Test Array-based Queue
        System.out.println("\n--- Testing Queue Using Array ---");
        queueUsingArray qArray = new queueUsingArray();
        qArray.push(100);
        qArray.push(200);
        qArray.push(300);
        qArray.display(); // Output: 100 200 300
        qArray.delete();  // Output: deleted element is :100
        qArray.display(); // Output: 200 300
    }
    
}

class queueUsingStack{

    ArrayList<Integer> st=new ArrayList<>();
    ArrayList<Integer> st2=new ArrayList<>();
    public void push(int data){
        while(!st.isEmpty()){
            st2.add(st.remove(st.size()-1));
        }

        st.add(data);
        while(!st2.isEmpty()){
            st.add(st2.remove(st2.size()-1));
        }
    }

    public void delete(){
        if(st.isEmpty()){
            System.out.println("queue is underFlow: ");
        }

        int remo=st.remove(st.size()-1);
        System.out.println("data deleted is :"+ remo);
    }

    public void display(){
        if (st.isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        // Print from top to bottom of the stack to show correct FIFO order
        for (int i = st.size() - 1; i >= 0; i--) {
            System.out.print(st.get(i) + " ");
        }
        System.out.println();
    }
}

class queueUsingArray{
    int rear=0;
    int front=0;

    int arr[]=new int[100];
    public  void push(int data){
        if(front==arr.length){
             System.out.println("Queue is overflow");
        }
        arr[front] = data;
        front++;

    }
    public void delete(){
        if (rear == front) {
            System.out.println("Queue is underflow");
            return;
        }
        int remov=arr[rear];
        System.out.println("deleted element is :"+ remov);
        rear++;
    }

    public void display(){
        if (rear == front) {
            System.out.println("Queue is empty");
            return;
        }
        // Iterate only up to front (excluding front itself)
        for (int i = rear; i < front; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}