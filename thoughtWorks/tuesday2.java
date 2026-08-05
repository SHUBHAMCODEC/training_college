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


    private static void InserAtBeginn(int data){
        Node curr=head.next;
        Node newNode=new Node(data);
        head=newNode;
        head.next=curr;

        printll(head);

    }

    private static void Insert_at_End(Node head,int data){

        Node newNode=new Node(data);
        Node curr=head;

        while(curr.next!=null){
            curr.next=newNode;
            curr=curr.next;
            curr.next=null;
        }

        printll(head);
    }

    private static Node deleteNode(Node head,int data){
        
        Node temp=head;
        if (temp.data==data){
            return null;
        }
        Node prev=null;
        while(temp.data!=data){
            prev=temp;
            temp=temp.next;
        }
        prev.next=prev.next.next;

        return head;
    }

    private static void searchElement(Node head,int data){
        Node temp=head;
        int count=0;

        while(temp.data!=data){
            count++;
            temp=temp.next;
        }

        System.out.println(data+" found at place "+ count);
    }

    private static void middleOfll(Node head){// turtoise-hair algorithm
        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        System.out.println("Middle List is "+ slow.data);
    }

    private static boolean detectCycle(Node head){
        Node slow=head,fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }

        return false;
    }

    private static void firstOfCycle(Node head){
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

                System.out.println("First Element of Cycle is: "+ slow.data);
            }
        }
    }

    private static void removeNthNode(Node head,int target){
        

        Node revTemp=reverseByrecursion(head);
        int count=1;
        Node prev=null,temp=revTemp;
        while(count!=target){
            count++;
            prev=temp;
            temp=temp.next;
        }
        prev.next=temp.next;

        Node OriTemp=reverseByrecursion(revTemp);

        printll(OriTemp);
    }


    private static Node MergeTwoList(Node list1,Node list2){
        Node DummyHead=new Node(-1);
        Node dummyTemp=DummyHead;
        Node temp1=list1,temp2=list2;

        if(temp1==null){
            return temp2;
        }else if(temp2==null){
            return temp1;
        }
        while(temp1!=null && temp2!=null){
            if(temp1.data<temp2.data){
                dummyTemp.next=temp1;
                dummyTemp=dummyTemp.next;
                temp1=temp1.next;
            }else{
                dummyTemp.next=temp2;
                dummyTemp=dummyTemp.next;
                temp2=temp2.next;
                
                
            }
        }
        while(temp1!=null){
            dummyTemp.next=temp1;
            dummyTemp=dummyTemp.next;
            temp1=temp1.next;

        }while(temp2!=null){
            dummyTemp.next=temp2;
            dummyTemp=dummyTemp.next;
            temp2=temp2.next;
        }

        return DummyHead.next;
    }

    private static Node removeDuplicates(Node head){
        Node curr=head.next,prev=head;
        while(curr!=null){
            if(curr.data!=prev.data){
                prev.next=curr;
                prev=prev.next;
                curr=curr.next;
            }
        }

        return prev;

    }

    private static void OddEvenList(Node head){
        Node OddHead=head.next; Node EvenHead=head;
        Node tempOdd=OddHead; Node tempEven=EvenHead;
        while(tempOdd!=null && tempOdd.next!=null){
            tempOdd.next=tempOdd.next.next;
            tempOdd=tempOdd.next;
        }
        while(tempEven!=null && tempEven.next!=null){
            tempEven.next=tempEven.next.next;
            tempEven=tempEven.next;
        }

        if(tempOdd==null || tempOdd.next==null){
            tempOdd.next=null;
        }else{
            tempEven.next=null;
        }
    }
    public static void main(String[] args) {
        creation(new int[]{1,2,3,4,5,6});
        reverseBYiterative();
        Node recurRever=reverseByrecursion(head);
        printll(recurRever);

    }


}
