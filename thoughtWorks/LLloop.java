public class LLloop { 
    static class Node { 
        int data; 
        Node next; 
        Node(int data) { 
            this.data = data; 
            this.next = null; 
        } 
    } 

    static Node head = null; 

    // FIXED: Removed temp.next = head to keep it linear by default.
    // Call createLoop() explicitly if testing cycle logic.
    private static void creation(int arr[]) { 
        if (arr == null || arr.length == 0) return;
        head = new Node(arr[0]); 
        Node temp = head; 
        for (int i = 1; i < arr.length; i++) { 
            Node newNode = new Node(arr[i]); 
            temp.next = newNode; 
            temp = temp.next; 
        } 
    } 

    // Helper to explicitly inject a cycle for testing loop methods
    private static void createLoop() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head; // Forms cycle
    }

    private static void helperLoop() { 
        Node slow = head, fast = head; 
        int flag = 0; 
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
            if (slow == fast) { 
                System.out.println("Loop is detected ..."); 
                flag = -1; 
                return; 
            } 
        } 
        if (flag == 0) { 
            System.out.println("Loop not detected.. "); 
        } 
    } 

    private static void firstElementOfLoop() { 
        Node slow = head, fast = head; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                slow = head; 
                while (slow != fast) { 
                    slow = slow.next; 
                    fast = fast.next; 
                } 
                System.out.println("Starting point of cycle is : " + slow.data); 
                return; 
            } 
        } 
    } 

    private static void deleteLoop() { 
        Node slow = head, fast = head; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                slow = head; 
                // Special handle case: If loop starts at head node
                if (slow == fast) {
                    while (fast.next != slow) {
                        fast = fast.next;
                    }
                } else {
                    while (slow.next != fast.next) { 
                        slow = slow.next; 
                        fast = fast.next; 
                    } 
                }
                fast.next = null; // Break loop
                System.out.println("Loop successfully broken/deleted.");
                return; 
            } 
        } 
    } 

    private static void removeDuplicatesFromSortedLL() { 
        if (head == null) return;
        Node prev = head; 
        Node temp = head.next; 
        while (temp != null) { 
            if (prev.data == temp.data) { 
                temp = temp.next; 
            } else { 
                prev.next = temp; 
                prev = prev.next; 
                temp = temp.next; 
            } 
        } 
        prev.next = null; // FIXED: Detaches any trailing duplicates at the tail

        printList("List after duplicate removal from sorted LL: ");
    } 

    // FIXED: Receives head explicitly to process distinct sub-lists correctly
    private static Node MergeSort(Node currHead) { 
        if (currHead == null || currHead.next == null) return currHead; 
        
        Node middle = middleForMergeSort(currHead); 
        Node lefthalf = currHead; 
        Node rightHalf = middle.next; 
        middle.next = null; 

        Node leftHead = MergeSort(lefthalf); 
        Node rightHead = MergeSort(rightHalf); 
        return merge(leftHead, rightHead); 
    } 

    private static Node merge(Node left, Node right) { 
        Node dummy = new Node(-1); 
        Node temp = dummy; 
        while (left != null && right != null) { 
            if (left.data < right.data) { 
                temp.next = left; 
                left = left.next; 
            } else { 
                temp.next = right; 
                right = right.next; 
            } 
            temp = temp.next;
        } 
        if (left != null) temp.next = left; 
        if (right != null) temp.next = right; 
        return dummy.next; 
    } 

    // FIXED: Dynamically accepts sublist head instead of a static global variable
    private static Node middleForMergeSort(Node currHead) { 
        if (currHead == null) return null; 
        Node slow = currHead, fast = currHead.next; 
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
        } 
        return slow; 
    } 

    private static void removeDuplicatesFromUnsortedLL() { 
        if (head == null) return;
        Node head2 = MergeSort(head); 
        Node prev = head2; 
        Node temp = head2.next; 
        while (temp != null) { 
            if (prev.data == temp.data) { 
                temp = temp.next; 
            } else { 
                prev.next = temp; 
                prev = prev.next; 
                temp = temp.next; 
            } 
        } 
        prev.next = null; // FIXED: Cuts dangling tail duplicates
        head = head2;     // Updates global head reference to sorted head

        printList("List after duplicate removal from Unsorted LL: ");
    } 

    private static void Move_last_element_to_front() { 
        if (head == null || head.next == null) return;
        Node prev = null, temp = head; 
        while (temp.next != null) { 
            prev = temp; 
            temp = temp.next; 
        } 
        temp.next = head; 
        prev.next = null; 
        head = temp; // FIXED: Points global head to the new front node

        printList("List after Move last element to front: ");
    } 

    private static void printList(String message) {
        Node temp = head; 
        System.out.println(message); 
        while (temp != null) { 
            System.out.print(temp.data + " "); 
            temp = temp.next; 
        } 
        System.out.println("\n"); 
    }

    public static void main(String[] args) { 
        // 1. Testing Standard Non-loop Operations
        System.out.println("--- Testing Linear Algorithms ---");
        int[] data = {4, 2, 2, 8, 1, 4, 3, 3};
        creation(data);
        
        removeDuplicatesFromUnsortedLL(); // Will sort and remove duplicates
        Move_last_element_to_front();

        // 2. Testing Loop/Cycle Operations
        System.out.println("--- Testing Loop Algorithms ---");
        int[] cycleData = {10, 20, 30, 40};
        creation(cycleData);
        createLoop(); // Make it circular explicitly
        
        helperLoop();
        firstElementOfLoop();
        deleteLoop();
        
        // Confirming loop deletion converted it back safely
        printList("List verification after loop deletion:");
    } 
}
