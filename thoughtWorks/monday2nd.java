public class monday2nd {

    private static void main(String [] args){
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

class stackByLinkedlist{
    static class st{
        int data;
        st next;
        
        st(int data){
            this.data=data;
            this.next=null;
        }
    }

    static st ptr=null;

    public void push(int data){
        st element=new st(data);
        if(ptr==null){
            ptr=element;
        }
        st temp=element;
        temp.next=ptr;
        ptr.next=temp;
    }
    
    public void pop(){
        int item=ptr.data;
        ptr=ptr.next;
        System.out.println("Popped element is vis LINKEDLIST :"+ item);
    }
    
    public void display(){
        st temp=ptr;
        System.out.println("Stack element is VIS LINKEDLIST : ");
        while(temp!=null){
            System.out.print(temp.data);
            temp=temp.next;
        }
    }
}
