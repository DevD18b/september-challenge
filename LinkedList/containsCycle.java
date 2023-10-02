package LinkedList;

public class containsCycle {
    public static boolean hasCycle(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    // add on question using this logic
    public static Node findNodeWhereCycleExist(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) { // this will give us an asurity ki cycle exist huii hai
                slow = head;
                while (slow != fast) { // now kaha hui hai uske liye we have this.-
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

class Node {
    Node next;
    int data;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}
