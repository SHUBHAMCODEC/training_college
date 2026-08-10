package thoughtWorks;



public class monday2nd {

    public  static void main(String [] args){
        stack st_arrStack=new stack();

        st_arrStack.add(10);
        st_arrStack.add(50);
        st_arrStack.add(100);
        st_arrStack.add(150);
        st_arrStack.add(210);
        st_arrStack.add(109);
        st_arrStack.display();
        st_arrStack.add(101);
        st_arrStack.display();
        st_arrStack.pop();
        st_arrStack.pop();
        st_arrStack.pop();
        st_arrStack.display();
        st_arrStack.add(105);
        st_arrStack.add(65);
        st_arrStack.pop();
        st_arrStack.display();


        //----------------------------------------------------------------

        stackByLinkedlist st_ls=new stackByLinkedlist();
System.out.println("//---------------------------------------------------------------------------//");
        st_ls.push(1);
        st_ls.push(2);
        st_ls.push(3);
        st_ls.push(4);
        st_ls.pop();
        st_ls.display();
        st_ls.push(5);
        st_ls.push(9);
        st_ls.display();
        st_ls.pop();
        st_ls.pop();    
        st_ls.pop();
        st_ls.display();


    }
}

class stack{
    int stack[]=new int[200];
    int ptr=-1;

    public void add(int data){
        stack[++ptr]=data;
        System.out.println();
    }

    public void pop(){
        int item=stack[ptr];
        stack[ptr]=0;
        ptr--;
        System.out.println();
        System.out.print("Elemenet popped from the stack is: "+ item);
        System.out.println();
    }

    public void display(){
        int dummyPtr=ptr;
        System.out.println("Stack element is : ");
        while(dummyPtr>=0){
            System.out.print(stack[dummyPtr]+" ");
            
            dummyPtr--;
        }

        System.out.println("\n");
    }
}

class stackByLinkedlist{
    static class st{
        int data;
        st next;
        
        st(int data){
            this.data=data;
            this.next=null;
        }
    }

    st ptr=null;

    public void push(int data){
        st element=new st(data);
        element.next=ptr;
        ptr=element;
        System.out.println();
    }
    
    public void pop(){
        int item=ptr.data;
        ptr=ptr.next;
        System.out.println("\n");
        System.out.print("Popped element is vis LINKEDLIST :"+ item);
        System.out.println();
    }
    
    public void display(){
        st temp=ptr;
        System.out.println("Stack element is VIS LINKEDLIST : ");
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        System.out.println();
    }
}

class queue_Array{
    int [] queue=new int[200];

    int rear=-1,front=-1;

    public void enque(int data){
        if(front==queue.length){
            System.out.println("queue is overFlow...");
        }
        if(front==-1 && rear ==-1){
            front =0;
            rear=0;
            queue[front]=data;
        }

        queue[++front]=data;

    }

    public void deque(){
        if(rear>front){
            System.out.println("nothing to delete , kindly enque some data...");
        }
        int item=queue[rear];
        queue[rear++]=0;
        System.out.print("deleted element is :"+item);
        System.out.println("\n");
    }

    public void display(){
        System.out.print("Queue element is: ");
        for(int i=rear;i<front;i++){
            System.out.print(queue[i]+" ");
        }
        System.out.println();
    }


}

class QueueList{

    static class queueLs{
        int data;
        queueLs next;

        public queueLs(int data) {
            this.data;
            this.next=null;
        }
    }

    queueLs rear=null;
    
    public void enque(int data){

        queueLs newEl=new queueLs(data);
        if(rear==null){
            rear= newEl;
        }
        queueLs front=rear;
        while(front.next!=null){
            front=front.next;
        }
        front.next=newEl;
    }

    public void deque(){
        int item=rear.data;
        rear=rear.next;
        System.out.println();
        System.out.println("Dequed eleemnt is:"+ item);
        System.out.println();
    }

    public void display(){
        queueLs front=rear;
        System.out.println("Queue element are: ");
        while(front!=null){
            System.out.println(front.data+" ");
            front=front.next;
        }

        System.out.println();
    }
}
