public class LLloop {

    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node head=null;

    private static void creation(int arr[]){

        head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=temp.next;
        }

        temp.next=head;
    }

    private static void helperLoop(){
        Node slow=head,fast=head;
        int flag=0;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(slow==fast){
                System.out.println("loop is detected ...");
                flag=-1;
                return;
            }
        }

        if(flag==0){
            System.out.println("loop not detected.. ");
        }
    }

    private static void firstElementOfLoop(){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                System.out.println("Starting points of cycle is : "+ slow.data);
                return;
            }
        }
    }

    private static void deleteLoop(){
        Node slow=head,fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

            if(slow==fast){
                
                while(fast.next!=slow){
                    fast=fast.next;
                }
                fast.next=null;
             
                return;
            }
        }
    }

    
    public static void main(String[] args) {
        
    }
}
