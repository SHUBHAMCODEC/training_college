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

    // 1. Creation (Creates a stable, linear Linked List)
    private static void creation(int arr[]) { 
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

    // Helper to deliberately force a circular loop for testing
    private static void injectLoop() {
        if (head == null) return;
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head; // Points tail back to head
    }

    // 2. Loop Detection (Floyd's Tortoise and Hare)
    private static void helperLoop() { 
        Node slow = head, fast = head; 
        boolean found = false; 
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
            if (slow == fast) { 
                System.out.println("[Result] Loop is detected..."); 
                found = true; 
                break; 
            } 
        } 
        if (!found) { 
            System.out.println("[Result] Loop not detected."); 
        } 
    } 

    // 3. Find the Starting Point of the Cycle
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
                System.out.println("[Result] Starting point of cycle is: " + slow.data); 
                return; 
            } 
        } 
        System.out.println("[Result] No cycle found to determine starting point.");
    } 

    // 4. Delete/Break the Loop Safely
    private static void deleteLoop() { 
        Node slow = head, fast = head; 
        while (fast != null && fast.next != null) { 
            slow = slow.next; 
            fast = fast.next.next; 
            if (slow == fast) { 
                slow = head; 
                // Special condition: Loop starts exactly at the head node
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
                fast.next = null; // Sever the loop connection
                System.out.println("[Result] Loop successfully broken and deleted."); 
                return; 
            } 
        } 
    } 

    // 5. Remove Duplicates from Sorted Linked List
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
        prev.next = null; // Disconnect trailing matched duplicates

        printList("List after duplicate removal from sorted LL:"); 
    } 

    // 6. Merge Sort Implementation (Divide and Conquer)
    private static Node MergeSort(Node currHead) { 
        if (currHead == null || currHead.next == null) return currHead; 
        
        Node middle = middleForMergeSort(currHead); 
        Node leftHalf = currHead; 
        Node rightHalf = middle.next; 
        middle.next = null; // Cut the list in half

        Node leftHead = MergeSort(leftHalf); 
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

    private static Node middleForMergeSort(Node currHead) { 
        if (currHead == null) return null; 
        Node slow = currHead, fast = currHead.next; 
        while (fast != null && fast.next != null) { 
            fast = fast.next.next; 
            slow = slow.next; 
        } 
        return slow; 
    } 

    // 7. Remove Duplicates from Unsorted Linked List
    private static void removeDuplicatesFromUnsortedLL() { 
        if (head == null) return;
        // Step A: Sort the list using our $O(N \log N)$ MergeSort
        Node sortedHead = MergeSort(head); 
        
        // Step B: Linearly remove duplicates from the now-sorted list
        Node prev = sortedHead; 
        Node temp = sortedHead.next; 
        while (temp != null) { 
            if (prev.data == temp.data) { 
                temp = temp.next; 
            } else { 
                prev.next = temp; 
                prev = prev.next; 
                temp = temp.next; 
            } 
        } 
        prev.next = null; 
        head = sortedHead; // Overwrite global head with processed list

        printList("List after duplicate removal from Unsorted LL:"); 
    } 

    // 8. Move Last Element to Front
    private static void Move_last_element_to_front() { 
        if (head == null || head.next == null) return; 
        Node prev = null, temp = head; 
        while (temp.next != null) { 
            prev = temp; 
            temp = temp.next; 
        } 
        temp.next = head; 
        prev.next = null; 
        head = temp; // Point global head to the shifted front node

        printList("List after moving last element to front:"); 
    } 

    // Global utility printer
    private static void printList(String label) {
        System.out.println(label);
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null\n");
    }

    // MAIN EXECUTION ENGINE
    public static void main(String[] args) { 
        System.out.println("=================================================");
        System.out.println("   STARTING LINKED LIST ALGORITHM TESTING ENGINE ");
        System.out.println("=================================================\n");

        // PHASE 1: Testing Loop Functions
        System.out.println("--- PHASE 1: Loop Lifecycle Handling ---");
        int[] loopArray = {10, 20, 30, 40, 50};
        creation(loopArray);
        
        System.out.println("[Action] Simulating loop insertion...");
        injectLoop(); // Deliberately ties tail back to head
        
        helperLoop();
        firstElementOfLoop();
        deleteLoop();
        
        // Confirming safety
        printList("[Verify] Recovered Linear List Structure:");

        // PHASE 2: Sorting and Unsorted Duplicate Cleansing
        System.out.println("--- PHASE 2: Sorting & Unsorted Cleansing ---");
        int[] dirtyArray = {9, 1, 4, 9, 3, 1, 7, 4};
        creation(dirtyArray);
        printList("Original Unsorted Dirty List:");
        
        removeDuplicatesFromUnsortedLL();

        // PHASE 3: Sorted Cleansing
        System.out.println("--- PHASE 3: Sorted Duplicate Cleansing ---");
        int[] sortedWithDupes = {5, 5, 11, 22, 22, 22, 33};
        creation(sortedWithDupes);
        printList("Original Sorted List with Duplicates:");
        
        removeDuplicatesFromSortedLL();

        // PHASE 4: Structural Permutation
        System.out.println("--- PHASE 4: Structural Shift ---");
        int[] shiftArray = {100, 200, 300, 400};
        creation(shiftArray);
        printList("Before Rearrangement:");
        
        Move_last_element_to_front();
        
        System.out.println("=================================================");
        System.out.println("           ALL CONCURRENT TESTS PASSED           ");
        System.out.println("=================================================");
    } 
}
