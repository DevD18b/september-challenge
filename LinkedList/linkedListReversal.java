package LinkedList;

public class linkedListReversal {

    public static Node reverseRange(Node head, int left, int right) {

        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;

        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        Node current = prev.next;
        for (int i = left; i < right; i++) {
            Node temp = prev.next;
            prev.next = current.next;
            // this is to remove cycles.
            current.next = current.next.next;
            prev.next.next = temp;
        }
        return dummy.next;

    }
}
