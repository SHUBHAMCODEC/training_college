public class monday2nd {

    private static void main(String [] args){
        
    }
}

class stack{
    static int stack[]=new int[200];
    static int ptr=-1;

    public void add(int data){
        stack[++ptr]=data;
    }

    public void pop(){
        int item=stack[ptr];
        stack[ptr]=0;
        ptr--;

        System.out.println("Elemenet popped from the stack is: "+ item);
    }

    public void display(){
        int dummyPtr=ptr;
        System.out.println("Stack element is : ");
        while(dummyPtr>=0){
            System.out.print(stack[dummyPtr]+" ");

            dummyPtr--;
        }
    }
}
