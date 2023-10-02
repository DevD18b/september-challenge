package LinkedList;

import java.util.HashMap;

public class cloneNodeWithRandomPoitner {
    public static Node driver(Node head) {
        // first thing i need to do is
        // build a deep copy
        // jisme next node as it is hum form kr rahe honge.
        if (head == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Node currentList = head;
        Node newHeadOfCopyList = null;
        Node traversingPointerOfCopyList = null;
        while (currentList != null) {
            Node temp = new Node(currentList.data);
            map.put(currentList, temp);
            if (newHeadOfCopyList == null) {
                newHeadOfCopyList = temp;
                traversingPointerOfCopyList = temp;
            } else {
                traversingPointerOfCopyList.next = temp;
                traversingPointerOfCopyList = temp;
            }
            currentList = currentList.next;
        }
        currentList = head;
        Node deepCopyOfRandomPointer = newHeadOfCopyList;
        while (currentList != null) {
            if (currentList != null) {
                deepCopyOfRandomPointer.random = map.get(currentList.random);
                deepCopyOfRandomPointer = deepCopyOfRandomPointer.next;
                currentList = currentList.next;
            }
        }
        return newHeadOfCopyList;
    }

}

class Node {
    Node next;
    int data;
    Node random;

    Node(int data) {
        this.data = data;
        this.next = this.random = null;
    }
}
