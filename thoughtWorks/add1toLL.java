package thoughtWorks;

public class add1toLL {

    static class Node{
        
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node head1=null;
    private static void creation(int [] arr){
        head1=new Node(arr[0]);
        Node temp=head1;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=temp.next;
        }
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
    private static void helper(Node head){
        Node slow=reverse(head);
        Node temp2=slow;
        int carry=1;
        while(temp2.next!=null && carry!=0){
            if(temp2.data==9){
                temp2.data=0;
                
            }else if(temp2.data<8){
                temp2.data+=carry;
                carry=0;
            }

            temp2=temp2.next;
        }
        while(temp2.next!=null){
            temp2=temp2.next;
        }

        head=reverse(temp2);
        print(head);
    }
//main function for the code
    private static void print(Node head){
        Node temp2=head;
        System.out.println("list is: ");
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }

        System.out.print("NULL");
    }
    public static void main(String[] args) {
        int arr[]={4,5,6};
        creation(arr);
        helper(head1);
    }
}
