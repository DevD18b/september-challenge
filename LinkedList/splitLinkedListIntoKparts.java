package LinkedList;

public class splitLinkedListIntoKparts {

    public static Node[] driver(Node head, int k) {

        Node current = head;
        int length = countNodes(head);
        int numberOfNodesInEachPartition = length / k;
        int remainingNodes = length % k;

        Node[] result = new Node[k];
        Node prev = null;
        // form k buckets;
        for (int i = 0; i < k; i++) {
            result[i] = current;

            // Node prev = null;
            for (int j = 0; j <= numberOfNodesInEachPartition + (remainingNodes > 0 ? 1 : 0); j++) {
                prev = current;
                current = current.next;
            }
            if (prev != null) {
                prev.next = null;
            }
            remainingNodes--;
        }
        return result;

    }

    public static int countNodes(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
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
