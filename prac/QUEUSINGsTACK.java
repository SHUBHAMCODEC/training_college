package prac;

public class QUEUSINGsTACK {
  

        static class Node{
            Node next;
            int data;
    
            Node(int data){
                this .data=data;
                this.next=null;
            }
        }
    
        static Node mainHead=null;
    
        private static Node creation(int arr[]){
            mainHead=new Node(arr[0]);
            Node temp=mainHead;
    
            for(int i=1;i<arr.length;i++){
                Node newNode=new Node(arr[i]);
                temp.next=newNode;
                temp=temp.next;
            }
    
            return mainHead;
        }
        private static Node reverse(Node head){
            if(head==null || head.next==null){
                return head;
            }
    
            Node newHead=reverse(head.next);
    
            head.next.next=head;
            head.next=null;
    
            return newHead;
        }
        private static Node add1(Node head){// adding function
            Node slow=reverse(head);
    
    
            Node prev=null;Node temp=slow;
            int carry=1;
            while(temp!=null && carry!=1){
                if(temp.data==9){
                    temp.data=0;
                }else if (temp.data<9) {
                    temp.data+=1;
                    // carry=0;
                    return reverse(slow);
                }
                prev=temp;
                temp=temp.next;
            }
    
            if(temp==null && carry==1){
                Node newNode=new  Node(carry);
                prev.next=newNode;
            }
            return reverse(slow);
        }
    
        private static void print(Node head){//print function
            Node temp=head;
            System.out.println("List:  ");
            while(temp!=null){
                System.out.print(temp.data+" ");
                temp=temp.next;
            }
    
            System.out.print("NUll");
        }
        public static void main(String[] args){//main function of the codee
            Node creaHead=creation(new int[]{1,2,3,4,5,6});
            Node finalHead=add1(creaHead);
            print(finalHead);//print function
        }
    
}
