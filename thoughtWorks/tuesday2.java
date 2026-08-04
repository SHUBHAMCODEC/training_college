public class tuesday2 {
    static class Node{
        Node next;
        int data;

        Node (int data){
            this.data=data;
            this.next=null;
        }
    }

    static Node head=null;
    private static void creation(int[] arr){
        head=new Node(arr[0]);

        Node temp=head;
        for(int i=1;i<arr.length;i++){
            Node newNode=new Node(arr[i]);
            temp.next=newNode;
            temp=temp.next;
        }
    }
    private static void printll(Node head1){
        Node dummy=head1;
        System.out.println("LinkedList printing: ");
        while(dummy!=null){
            System.out.print(dummy.data+" - ");
            dummy=dummy.next;
        }
    }
    private static void reverseBYiterative(){
        Node prev=null;
        Node curr=head;
        while(curr!=null){
            Node next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }

        printll(prev);
    }
    private static Node reverseByrecursion(Node headDummy){
        if(headDummy==null || headDummy.next==null){
            return headDummy;
        }
        
        Node newNode=reverseByrecursion(headDummy.next);
        newNode.next.next=headDummy;
        headDummy.next=null;

        return newNode; 
    }

    public static void main(String[] args) {
        creation(new int[]{1,2,3,4,5,6});
        reverseBYiterative();
        Node recurRever=reverseByrecursion(head);
        printll(recurRever);
    }


}
