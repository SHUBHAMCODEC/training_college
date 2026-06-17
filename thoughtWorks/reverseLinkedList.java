class reverseLinkedList{
    static class Node{
        int data;
        Node next;


        Node(int data){
            this.data=data;
            this.next=null;
        }
    }


    static Node head=null;

    private static Node reversebyK(Node temp){
        if(temp==null || temp.next==null){
            return temp;
        }

        Node newHead=reversebyK(temp.next);
        temp.next.next=temp;
        temp.next=null;

        return newHead;
    }
    private static void reverse(Node head,int target){
        int k=0;
        Node temp2=head;
        while(k!=target){
            temp2=temp2.next;
            k++;
        }
        Node dummy=temp2.next;
        Node slow=reversebyK(temp2;)
    }

    private static void creation(int[] arr){
        head=new Node(arr[0]);
        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=temp.next;
        }
    }
    private static void helperIterative(){
        System.out.println("Before reverse: ");
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp=temp.next;
        }
        
        Node curr=head;
        Node prev=null;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
        Node temp2=prev;
        System.out.println("Before reverse: ");
       
        while(temp2!=null){
            System.out.print(temp2.data+" ");
            temp2=temp2.next;
        }

    }

    
    private static void printList(Node node) {
        while (node != null) { 
            System.out.print(node.data + " "); 
            node = node.next; 
        } 
        System.out.println();
    }

    private static Node helperRecur(Node temp){
        if(temp==null || temp.next==null){
            return temp;
        }

        Node newHead=helperRecur(temp.next);
        temp.next.next=temp;
        temp.next=null;

        return newHead;
    }
    public static void main(String [] args){
       creation(new int[]{1, 2, 3, 4, 5, 6, 7, 10, 15, 16}); 
        
        helperIterative(); 
        
        System.out.println("\nReversing back using Recursion...");
        head = helperRecur(head); // FIXED: Capture returned head to update state
        
        System.out.println("After Recursive Reverse: ");
        printList(head);
    }
}