public class tuesday2 { 
    static class Node { 
        Node next; 
        int data; 
        Node (int data) { 
            this.data = data; 
            this.next = null; 
        } 
    } 
    
    static Node head = null; 

    private static void creation(int[] arr) { 
        if (arr == null || arr.length == 0) {
            head = null;
            return;
        }
        head = new Node(arr[0]); 
        Node temp = head; 
        for (int i = 1; i < arr.length; i++) { 
            Node newNode = new Node(arr[i]); 
            temp.next = newNode; 
            temp = temp.next; 
        } 
    } 

    private static void printll(Node head1) { 
        Node dummy = head1; 
        System.out.print("LinkedList printing: "); 
        while (dummy != null) { 
            System.out.print(dummy.data + " -> "); 
            dummy = dummy.next; 
        } 
        System.out.println("null");
    } 

    private static Node reverseBYiterative(Node headNode) { 
        Node prev = null; 
        Node curr = headNode; 
        while (curr != null) { 
            Node next = curr.next; 
            curr.next = prev; 
            prev = curr; 
            curr = next; 
        } 
        return prev; 
    } 

    private static Node reverseByrecursion(Node headDummy) { 
        if (headDummy == null || headDummy.next == null) { 
            return headDummy; 
        } 
        Node newNode = reverseByrecursion(headDummy.next); 
        headDummy.next.next = headDummy; 
        headDummy.next = null; 
        return newNode; 
    } 

    private static Node InserAtBeginn(Node headNode, int data) { 
        Node newNode = new Node(data); 
        newNode.next = headNode; 
        return newNode; 
    } 

    private static Node Insert_at_End(Node headNode, int data) { 
        Node newNode = new Node(data); 
        if (headNode == null) return newNode;
        Node curr = headNode; 
        while (curr.next != null) { 
            curr = curr.next; 
        } 
        curr.next = newNode;
        return headNode; 
    } 

    private static Node deleteNode(Node headNode, int data) { 
        if (headNode == null) return null;
        if (headNode.data == data) { 
            return headNode.next; 
        } 
        Node temp = headNode; 
        Node prev = null; 
        while (temp != null && temp.data != data) { 
            prev = temp; 
            temp = temp.next; 
        } 
        if (temp != null) {
            prev.next = temp.next; 
        }
        return headNode; 
    } 

    private static void searchElement(Node headNode, int data) { 
        Node temp = headNode; 
        int count = 0; 
        while (temp != null) { 
            if (temp.data == data) {
                System.out.println(data + " found at index " + count); 
                return;
            }
            count++; 
            temp = temp.next; 
        } 
        System.out.println(data + " not found in the list.");
    } 

    private static void middleOfll(Node headNode) { 
        if (headNode == null) return;
        Node slow = headNode, fast = headNode; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
        } 
        System.out.println("Middle element data is " + slow.data); 
    } 

    private static boolean detectCycle(Node headNode) { 
        Node slow = headNode, fast = headNode; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                return true; 
            } 
        } 
        return false; 
    } 

    private static void firstOfCycle(Node headNode) { 
        Node slow = headNode, fast = headNode; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                slow = headNode; 
                while (slow != fast) { 
                    slow = slow.next; 
                    fast = fast.next; 
                } 
                System.out.println("First Element of Cycle is: " + slow.data); 
                return;
            } 
        } 
        System.out.println("No cycle detected.");
    } 

    private static Node removeNthNodeFromEnd(Node headNode, int target) { 
        Node dummy = new Node(0);
        dummy.next = headNode;
        Node first = dummy;
        Node second = dummy;
        for (int i = 0; i <= target; i++) {
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    } 

    private static Node MergeTwoList(Node list1, Node list2) { 
        Node DummyHead = new Node(-1); 
        Node dummyTemp = DummyHead; 
        Node temp1 = list1, temp2 = list2; 
        
        while (temp1 != null && temp2 != null) { 
            if (temp1.data < temp2.data) { 
                dummyTemp.next = temp1; 
                temp1 = temp1.next; 
            } else { 
                dummyTemp.next = temp2; 
                temp2 = temp2.next; 
            } 
            dummyTemp = dummyTemp.next;
        } 
        if (temp1 != null) { 
            dummyTemp.next = temp1; 
        } else { 
            dummyTemp.next = temp2; 
        } 
        return DummyHead.next; 
    } 

    private static Node removeDuplicates(Node headNode) { 
        if (headNode == null) return null;
        Node curr = headNode; 
        while (curr != null && curr.next != null) { 
            if (curr.data == curr.next.data) { 
                curr.next = curr.next.next; 
            } else {
                curr = curr.next; 
            }
        } 
        return headNode; 
    } 

    private static Node OddEvenList(Node headNode) { 
        if (headNode == null || headNode.next == null) return headNode;
        Node odd = headNode;
        Node even = headNode.next;
        Node evenHead = even;
        
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return headNode;
    } 

    public static void main(String[] args) { 
        System.out.println("--- 1. Testing Creation and Print ---");
        creation(new int[]{10, 20, 30, 40, 50}); 
        printll(head); 

        System.out.println("\n--- 2. Testing Iterative Reverse ---");
        head = reverseBYiterative(head);
        printll(head); 

        System.out.println("\n--- 3. Testing Recursive Reverse ---");
        head = reverseByrecursion(head);
        printll(head); 

        System.out.println("\n--- 4. Testing Insert at Beginning ---");
        head = InserAtBeginn(head, 5);
        printll(head); 

        System.out.println("\n--- 5. Testing Insert at End ---");
        head = Insert_at_End(head, 60);
        printll(head); 

        System.out.println("\n--- 6. Testing Middle of LinkedList ---");
        middleOfll(head); 

        System.out.println("\n--- 7. Testing Search Element ---");
        searchElement(head, 30);
        searchElement(head, 99); // Edge-case testing item not present

        System.out.println("\n--- 8. Testing Delete Node ---");
        head = deleteNode(head, 5); // Delete head node
        head = deleteNode(head, 30); // Delete intermediate node
        printll(head);

        System.out.println("\n--- 9. Testing Remove Nth Node From End ---");
        head = removeNthNodeFromEnd(head, 2); // Removes 2nd from end
        printll(head);

        System.out.println("\n--- 10. Testing Cycle Detection & First Node of Cycle ---");
        System.out.println("Cycle detected? " + detectCycle(head));
        // Creating structural cycle intentionally: connect 60 to 20
        head.next.next.next.next.next = head.next; 
        System.out.println("Cycle detected after modification? " + detectCycle(head));
        firstOfCycle(head);

        System.out.println("\n--- 11. Testing Merge Two Sorted Lists ---");
        // Breaking cycle to clean up tests
        head.next.next.next.next.next = null; 
        creation(new int[]{1, 3, 5});
        Node list2 = new Node(2);
        list2.next = new Node(4);
        list2.next.next = new Node(6);
        System.out.print("List 1: "); printll(head);
        System.out.print("List 2: "); printll(list2);
        Node merged = MergeTwoList(head, list2);
        System.out.print("Merged List: "); printll(merged);

        System.out.println("\n--- 12. Testing Remove Duplicates ---");
        Node duplicateList = new Node(1);
        duplicateList.next = new Node(1);
        duplicateList.next.next = new Node(2);
        duplicateList.next.next.next = new Node(3);
        duplicateList.next.next.next.next = new Node(3);
        System.out.print("Before duplicate removal: "); printll(duplicateList);
        duplicateList = removeDuplicates(duplicateList);
        System.out.print("After duplicate removal: "); printll(duplicateList);

        System.out.println("\n--- 13. Testing Odd-Even Grouping by Index ---");
        creation(new int[]{1, 2, 3, 4, 5});
        System.out.print("Before Odd-Even split: "); printll(head);
        head = OddEvenList(head);
        System.out.print("After Odd-Even split: "); printll(head);
    } 
}
