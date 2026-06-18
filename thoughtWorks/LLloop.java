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
                slow=head;
                while(slow!=fast){
                    slow=slow.next;
                    fast=fast.next;
                }
                while(fast.next!=slow){
                    fast=fast.next;
                }
                fast.next=null;
             
                return;
            }
        }
    }

    private static void removeDuplicatesFromSortedLL(){
        Node prev=head; Node temp=head.next;

        while(temp!=null){
            if(prev.data==temp.data){
                temp=temp.next;
            }else if(prev.data!=temp.data){
                prev.next=temp;
                prev=prev.next;
                temp=temp.next;
            }
        }

        Node temp2=head;
        System.out.println("List is after duplicate removels from sorted LL : ");
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }
        System.out.println("\n\n");
    }
    private static void MergeSort(Node head,)
    private static void removeDuplicatesFromUnsortedLL(){
        int 
        MergeSort();
    }


    private static void Move_last_element_to_front(){
        Node prev=null,temp=head;

        while(temp!=null && temp.next!=null){
            prev=temp;
            temp=temp.next;
        }

        temp.next=head;
        prev.next=null;

        Node temp2=head;
        System.out.println("List after Move last element to front : ");
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }
        System.out.println("\n\n");
    }

    
    public static void main(String[] args) {
        
    }
}
